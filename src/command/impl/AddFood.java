package command.impl;

import command.Command;
import realization.objects.Food;
import realization.objects.Product;
import realization.workingOnFiles.FileServiceProduct;
import realization.workingOnFiles.FileServiceFood;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.List;
// добавить прием пищи - кушать
//не содержит в файле количество каллорий
//str: addFood -d 24.02.2022 -i 12 -n торт -w 100 -e 186

//str: addFood -i 12(product) -n торт -w 100 -e 186 +
//str: addFood -i 12(product) -n торт -w 100 +
//str: addFood -i 12(product) -w 100 +

//str: addFood -d 24.02.2022 -n торт -w 100 -e 186
//str: addFood -n торт -w 100 -e 186 +
//str: addFood -n торт -w 100 +
public class AddFood implements Command {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final static String PREFIX_INDEX = "-i";
    private final static String PREFIX_DATE = "-d";
    private final static String PREFIX_NAME = "-n";
    private final static String PREFIX_WEIGHT = "-w";
    private final static String PREFIX_ENERGY = "-e";
    private Integer index;
    private LocalDate date;
    private String name;

    private Integer weight;

    private Integer energy;

    private AddFood(LocalDate date, Integer index, String name, Integer weight, Integer energy) {
        this.date = date;
        this.index = index;
        this.name = name;
        this.weight = weight;
        this.energy = energy;
    }

    public static AddFood create(LinkedHashMap<String, String> typeAndValue) {

        String d = typeAndValue.get(PREFIX_DATE);
        String name = typeAndValue.get(PREFIX_NAME);
        String i = typeAndValue.get(PREFIX_INDEX);
        String w = typeAndValue.get(PREFIX_WEIGHT);
        String e = typeAndValue.get(PREFIX_ENERGY);

        LocalDate date;
        Integer weight;
        Integer energy;
        Integer index;
        try
        {
            weight = w != null ? Integer.valueOf(w) : null;
            energy = e != null ? Integer.valueOf(e) : null;
            index = i != null ? Integer.valueOf(i) : null;
            date = d != null ? LocalDate.parse(d,formatter) : null;
        }
        catch(NumberFormatException exception)
        {
            System.out.println("Некорректный формат числа.");
            return null;
        }
        catch (DateTimeParseException exception)
        {
            System.out.println("Некорректный формат даты.");
            return null;
        }
        return new AddFood(date, index, name, weight, energy);
    }

    @Override
    public void execute()
    {

        if (date == null)
        {
            date = LocalDate.now();
        }

        Product product = getProduct();
        if (product == null)
        {
            System.out.println("Не удалось найти продукт.");
            return;
        }


        Food food = Food.createFood(this.date, product.getName(), this.weight);
        FileServiceFood.addLineToFile(food);
    }

    private Product getProduct()
    {
        List<Product> products = FileServiceProduct.getListProductFromFile();
        Product product = null;
        if (index != null && name == null)
        {
            System.out.println("Ошибка добавления food не указано name или index product");
        }
        else if (index != null)
        {
            product = products.stream()
                    .filter(p -> p.getIndex().equals(index))
                    .findFirst().orElse(null);
            if (product == null)
            {
                System.out.println("Ошибка добавления food не найден index product");
            }
        }
        else if (name != null)
        {
            product = products.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst().orElse(null);
            if (product == null)
            {
                if (energy != null)
                {
                    product = Product.createProduct(this.name, this.energy);
                    FileServiceProduct.addLineToFile(product);
                }
                else if (energy == null)
                {
                    System.out.println("Ошибка добавления food не найден name product и energy");
                }
            }
        }
        return product;
    }

}
