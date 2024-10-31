package realization.workingOnFiles;

import realization.LineParser;
import realization.objects.Food;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileSirviceFood
{
    private final static String PATH_FOOD_FILE = "D:\\Java\\2. Project\\Calorie Calculator Project\\src\\file\\foodFile.csv";

    private final static String NAME_FOOD_FILE = "foodFile.csv";

    public static void deleteLineByIndex (Integer index) throws IOException
    {
        List<Food> foods = getFoodsFromFile();
        foods.stream()
                .filter(f -> f.getIndex() != index)
                .toList();
        overwriteToFile(convertToString(foods));
    }

    public static void deleteLineByName (String name) throws IOException
    {
        List<Food> foods = getFoodsFromFile();
        foods.stream()
                .filter(f -> !f.getName().equals(name))
                .toList();
        overwriteToFile(convertToString(foods));
    }

    public static Food getFoodByIndex (Integer index)
    {
        List<Food> foods = getFoodsFromFile();

        return foods.stream()
                .filter(f -> f.getIndex() == index)
                .findFirst()
                .orElse(null);
    }
    public static List<Food> getFoodsByDate (LocalDate date)
    {
        List<Food> foods = getFoodsFromFile();

        return foods.stream().collect(Collectors.toList());
                //.filter(f -> f.getDate().compareTo());
    }


    public static List<Food> getFoodsFromFile ()
    {
        List<Food> foods = new ArrayList<>();
        ;
        try (FileReader readerFile = new FileReader(PATH_FOOD_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String line = null;
            while (reader.ready())
            {
                line = reader.readLine();
                foods.add(Food.createFood(LineParser.parseLineFile(line)));
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return foods;
    }



    public static void addFoodToFile (List<Food> foods)
    {

    }

    private static List<String> convertToString (List<Food> foods)
    {
        List<String> infoValueFoods = new ArrayList<>();
        foods.stream()
                .map(product -> product.toString())
                .collect(Collectors.toList());
        return infoValueFoods;
    }

    private static void overwriteToFile (List<String> foods)
    {
        try (FileWriter fileWriter = new FileWriter(NAME_FOOD_FILE);)
        {
            for (String food : foods)
            {
                fileWriter.write(food);
            }
        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи в файл " + PATH_FOOD_FILE);
            e.printStackTrace();
        }
    }
}
