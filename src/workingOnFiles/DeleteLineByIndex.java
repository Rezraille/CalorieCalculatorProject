package workingOnFiles;

import objects.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DeleteLineByIndex
{
    static void delete (Integer index) throws IOException
    {
        //Path tempFile = Files.createTempFile("productFile", ".csv");
        List<Product> products = OutPut.getProductFromFile();
        products.stream().filter(f -> f.getIndex() == index).toList();
        //TODO ОЧИСТИТЬ ФАЙЛ
        InPut.addProductToFile(products);
        //tempFile.toFile().deleteOnExit();
    }
}
