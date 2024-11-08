package command.impl;

import command.Command;
import realization.objects.Food;
import realization.objects.Product;
import realization.workingOnFiles.FileServiceProduct;
import realization.workingOnFiles.FileSirviceFood;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        LocalDate date = d != null ? LocalDate.parse(d,formatter) : null;
        //TODO добавить обработку ошибок
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
        List<Food> foodsToDay = FileSirviceFood.getListFoodByDate(date);
        List<Product> productsToDay = new ArrayList<>();
        for (Food food:foodsToDay)
        {
            productsToDay.add(FileServiceProduct.getProductByFood(products,food));
        }
        List<Integer> energyProducts  = productsToDay.stream().map(p -> p.getEnergy()).collect(Collectors.toList());
        List<Integer> weightFoods = foodsToDay.stream().map(f -> f.getWeight()).collect(Collectors.toList());
        Integer callories = null;
        Integer sumCallories = 0;
        for (int i = 0; i < weightFoods.size(); i++)
        {
            callories = (weightFoods.get(i) * energyProducts.get(i))/WEIGHT_PRODUCT;
            sumCallories += callories;
        }
        System.out.printf("Сумма каллорий за дату %s - %d",date,sumCallories);;

    }
}
