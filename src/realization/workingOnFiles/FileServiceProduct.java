package realization.workingOnFiles;

import realization.LineParser;
import realization.objects.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceProduct
{
    private final static String PATH_PRODUCT_FILE = "file\\productFile.csv";

    public static void deleteLineByIndex (Integer index) throws IOException
    {
        List<Product> products = getListProductFromFile();
        products = products.stream()
                .filter(f -> f.getIndex() != index)
                .toList();
        overwriteToFile(convertToList(products));
    }

    public static void deleteLineByName (String name) throws IOException
    {
        List<Product> products = getListProductFromFile();
        products = products.stream()
                .filter(f -> !f.getName().equals(name))
                .toList();
        overwriteToFile(convertToList(products));
    }

    public static Product getProductByIndex (Integer index)
    {
        List<Product> products = getListProductFromFile();

        return products.stream()
                .filter(f -> f.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public static List<Product> getListProductFromFile ()
    {
        List<Product> products = new ArrayList<>();
        try (FileReader readerFile = new FileReader(PATH_PRODUCT_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String line = null;
            while (reader.ready())
            {
                line = reader.readLine();
                products.add(Product.createProductFromFile(LineParser.parseLineFile(line)));
            }

        }
        catch (IOException e)
        {
            System.out.println("Ошибка считывания файла " + PATH_PRODUCT_FILE);
            e.printStackTrace();
        }
        return products;
    }

    public static List<String> convertToList (List<Product> products)
    {
        List<String> infoValueProducts = products.stream()
                .map(product -> product.toScvString())
                .collect(Collectors.toList());
        return infoValueProducts;
    }

    public static void overwriteToFile (List<String> products)
    {
        try (FileWriter fileWriter = new FileWriter(PATH_PRODUCT_FILE);)
        {
            StringBuilder stringBuilder = new StringBuilder("");
            for (String product : products)
            {
                stringBuilder.append(product + "\n");
            }

            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();

        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи в файл " + PATH_PRODUCT_FILE);
            e.printStackTrace();
        }
    }
    public static void writeToFile (String line)
    {
        try (FileWriter fileWriter = new FileWriter(PATH_PRODUCT_FILE, true))
        {
            fileWriter.write(line);
            fileWriter.flush();
        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи строки в файл " + PATH_PRODUCT_FILE);
            e.printStackTrace();
        }
    }
    public static void addLineToFile(Product product)
    {
        String line = product.toScvString();
        writeToFile(line + "\n");

    }

}
