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
    private final static String PATH_PRODUCT_FILE = "D:\\Java\\2. Project\\Calorie Calculator Project\\src\\file\\productFile.csv";
    private final static String NAME_PRODUCT_FILE = "productFile.csv";

    public static void deleteLineByIndex (Integer index) throws IOException
    {
        List<Product> products = getProductsFromFile();
        products.stream()
                .filter(f -> f.getIndex() != index)
                .toList();
        overwriteToFile(convertToString(products));
    }

    public static void deleteLineByName (String name) throws IOException
    {
        List<Product> products = getProductsFromFile();
        products.stream()
                .filter(f -> !f.getName().equals(name))
                .toList();
        overwriteToFile(convertToString(products));
    }

    public static Product getProductByIndex (Integer index)
    {
        List<Product> products = getProductsFromFile();

        return products.stream()
                .filter(f -> f.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public static List<Product> getProductsFromFile ()
    {
        List<Product> products = new ArrayList<>();
        ;
        try (FileReader readerFile = new FileReader(PATH_PRODUCT_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String line = null;
            while (reader.ready())
            {
                line = reader.readLine();
                products.add(Product.createProduct(LineParser.parseLineFile(line)));
            }

        }
        catch (IOException e)
        {
            System.out.println("Ошибка считывания файла " + PATH_PRODUCT_FILE);
            e.printStackTrace();
        }
        return products;
    }


    public static void addProductsToFile (List<Product> products)
    {

    }

    private static List<String> convertToString (List<Product> products)
    {
        List<String> infoValueProducts = new ArrayList<>();
        products.stream()
                .map(product -> product.toString())
                .collect(Collectors.toList());
        return infoValueProducts;
    }

    private static void overwriteToFile (List<String> products)
    {
        try (FileWriter fileWriter = new FileWriter(NAME_PRODUCT_FILE);)
        {
            for (String product : products)
            {
                fileWriter.write(product);
            }
        }
        catch (IOException e)
        {
            System.out.println("Ошибка записи в файл " + PATH_PRODUCT_FILE);
            e.printStackTrace();
        }
    }

}
