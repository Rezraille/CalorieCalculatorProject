package workingOnFiles;

import objects.Food;
import objects.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class OutPut
{
    static List<Product> getProductFromFile ()
    {
        List<Product> products = null;
        try (FileReader readerFile = new FileReader(FileServise.PATH_PRODUCT_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String line = null;
            while (reader.ready())
            {
                line = reader.readLine();
                products.add(Product.createProduct(FileServise.parse(line)));
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    static List<Food> getFoodFromFile ()
    {
        List<Food> foods = null;
        try (FileReader readerFile = new FileReader(FileServise.PATH_FOOD_FILE); BufferedReader reader = new BufferedReader(readerFile))
        {
            String line = null;
            while (reader.ready())
            {
                line = reader.readLine();
                foods.add(Food.createFood(FileServise.parse(line));
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
