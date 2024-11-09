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

public class FileServiceFood {
    private final static String PATH_FOOD_FILE = "file\\foodFile.csv";

    public static void deleteLineByIndex(Integer index) throws IOException {
        List<Food> foods = getListFoodFromFile();
        foods = foods.stream()
                .filter(f -> f.getIndex() != index)
                .toList();
        overwriteToFile(convertToList(foods));
    }

    public static void deleteLineByName(String name) throws IOException {
        List<Food> foods = getListFoodFromFile();
        foods = foods.stream()
                .filter(f -> !f.getName().equals(name))
                .toList();
        overwriteToFile(convertToList(foods));
    }

    public static Food getFoodByIndex(Integer index) {
        List<Food> foods = getListFoodFromFile();

        return foods.stream()
                .filter(f -> f.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public static List<Food> getListFoodByDate(LocalDate date) {
        List<Food> foods = getListFoodFromFile();

        return foods.stream().
                filter(d -> d.getDate().equals(date))
                .collect(Collectors.toList());
    }


    public static List<Food> getListFoodFromFile() {
        List<Food> foods = new ArrayList<>();

        try (FileReader readerFile = new FileReader(PATH_FOOD_FILE); BufferedReader reader = new BufferedReader(readerFile)) {
            String line = null;
            while (reader.ready()) {
                line = reader.readLine();
                foods.add(Food.createFoodFromFile(LineParser.parseLineFile(line)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return foods;
    }

    private static List<String> convertToList(List<Food> foods) {
        List<String> infoValueFoods = foods.stream()
                .map(food -> food.toScvString())
                .collect(Collectors.toList());
        return infoValueFoods;
    }

    private static void overwriteToFile(List<String> foods)
    {

        try (FileWriter fileWriter = new FileWriter(PATH_FOOD_FILE);)
        {
            StringBuilder stringBuilder = new StringBuilder("");

            for (String food : foods)
            {
                stringBuilder.append(food + "\n");
            }
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи в файл " + PATH_FOOD_FILE);
            e.printStackTrace();
        }
    }

    public static void writeToFile (String line)
    {
        try (FileWriter fileWriter = new FileWriter(PATH_FOOD_FILE, true);)
        {
            fileWriter.write(line);
        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи строки в файл " + PATH_FOOD_FILE);
            e.printStackTrace();
        }
    }
    public static void addLineToFile(Food food)
    {
        String line = food.toScvString();
        writeToFile(line + "\n");

    }
}
