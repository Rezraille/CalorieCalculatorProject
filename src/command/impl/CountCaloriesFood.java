package command.impl;

import command.Command;
import realization.objects.Food;
import realization.objects.Product;
import realization.workingOnFiles.FileServiceFood;
import realization.workingOnFiles.FileServiceProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.List;

//посчитать и вывести в консоль сколько калорий съедено сегодня
//str: getCal - сегодня
//str: getCal -d - за определенную дату
public class CountCaloriesFood implements Command
{
    private final static Integer WEIGHT_PRODUCT = 100;
    private final static String PREFIX_DATE = "-d";
    private LocalDate date;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private CountCaloriesFood (LocalDate date)
    {
        this.date = date;
    }


    public static CountCaloriesFood create(LinkedHashMap<String,String> typeAndValue)
    {

        String d = typeAndValue.get(PREFIX_DATE);
        LocalDate date;
        try
        {
            date = d != null ? LocalDate.parse(d,formatter) : null;
        }
        catch (DateTimeParseException e)
        {
            System.out.println("Некорректный формат даты.");
            return null;
        }
        return new CountCaloriesFood(date);
    }
    @Override
    public void execute ()
    {
        if (date == null)
        {
            date = LocalDate.now();
        }

        List<Product> products = FileServiceProduct.getListProductFromFile();
        List<Food> foodsToDay = FileServiceFood.getListFoodByDate(date);

        Integer sumCallories = 0;
        for (Food food : foodsToDay)
        {
            Product product = getProductByFood(products,food);
            if (product == null)
            {
                System.out.println("Не могу найти продукт для " + food);
                return;
            }
            sumCallories+= (food.getWeight()* product.getEnergy()) / WEIGHT_PRODUCT;
        }
        System.out.printf("Сумма каллорий за дату %s - %d", date, sumCallories);
    }

    private static Product getProductByFood (List <Product>products, Food food)
    {
        for (Product product : products)
        {
            if (product.getName().equals(food.getName()))
            {
                return product;
            }
        }
        return null;
    }

}
