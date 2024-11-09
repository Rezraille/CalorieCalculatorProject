package realization.workingOnFiles;

import realization.LineParser;
import realization.objects.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceMaxValue
{
    private final static String PATH_MAX_INDEX_FILE = "file\\FileIndexMaxValue.csv";
    private static Integer indexPruduct = null;
    private static Integer indexFood = null;
    public static Integer setMaxIndexProduct ()
    {
        indexPruduct = getMaxIndexProductFromFile();
        indexPruduct++;
        addMaxIndexProductToFile(indexPruduct);
        return indexPruduct;
    }
    private static Integer getMaxIndexProductFromFile ()
    {
        try (FileReader readerFile = new FileReader(PATH_MAX_INDEX_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String str = reader.readLine();
            str = str.substring(0,str.indexOf(";"));
            indexPruduct = Integer.valueOf(str);
        }
        catch (IOException e)
        {
            System.out.println("Ошибка считывания product max index из файла " + PATH_MAX_INDEX_FILE);
            e.printStackTrace();
        }
        return indexPruduct;
    }
    private static void addMaxIndexProductToFile (Integer index)
    {
        Integer maxIndexFood = getMaxIndexFoodFromFile();
        try (FileWriter fileWriter = new FileWriter(PATH_MAX_INDEX_FILE);)
        {
            fileWriter.write(String.valueOf(index) + ";" + String.valueOf(maxIndexFood));
            fileWriter.flush();
        }
        catch (IOException e)
        {
            System.out.println("Ошибка добавления product max index в файл " + PATH_MAX_INDEX_FILE);
            e.printStackTrace();
        }
    }
    public static Integer setMaxIndexFood ()
    {
        indexFood = getMaxIndexFoodFromFile();
        indexFood++;
        addMaxIndexFoodToFile(indexFood);
        return indexFood;
    }
    private static Integer getMaxIndexFoodFromFile ()
    {
        try (FileReader readerFile = new FileReader(PATH_MAX_INDEX_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String str = reader.readLine();
            str = str.substring(str.indexOf(";")+1);
            indexFood = Integer.valueOf(str);
        }
        catch (IOException e)
        {
            System.out.println("Ошибка считывания food max index из файла " + PATH_MAX_INDEX_FILE);
            e.printStackTrace();
        }
        return indexFood;
    }
    private static void addMaxIndexFoodToFile (Integer index)
    {
        Integer maxIndexProduct = getMaxIndexProductFromFile();
        try (FileWriter fileWriter = new FileWriter(PATH_MAX_INDEX_FILE);)
        {
            fileWriter.write(String.valueOf(maxIndexProduct) + ";" + String.valueOf(index));
            fileWriter.flush();
        }
        catch (IOException e)
        {
            System.out.println("Ошибка добавления food max index в файл " + PATH_MAX_INDEX_FILE);
            e.printStackTrace();
        }
    }
}
