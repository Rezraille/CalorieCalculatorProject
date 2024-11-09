package command.impl;

import command.Command;
import realization.objects.Product;
import realization.workingOnFiles.FileServiceProduct;

import java.util.LinkedHashMap;
import java.util.List;

//добавить продукт, если он уже есть, то обновить ккал
//str: addProd -n мандарин -e 45
public class AddProduct implements Command
{
    private final static String PREFIX_NAME = "-n";
    private final static String PREFIX_ENERGY = "-e";

    private String name;

    private Integer energy;

    private AddProduct (String name, Integer energy)
    {
        this.name = name;
        this.energy = energy;
    }


    public static AddProduct create (LinkedHashMap<String, String> typeAndValue)
    {
        String name = typeAndValue.get(PREFIX_NAME);
        Integer energy;
        try
        {
            energy = Integer.valueOf(typeAndValue.get(PREFIX_ENERGY));
        }
        catch(NumberFormatException e)
        {
            System.out.println("Некорректный формат числа или отсутствует число.");
            return null;
        }
        return new AddProduct(name, energy);
    }

    @Override
    public void execute ()
    {
        List<Product> products = FileServiceProduct.getListProductFromFile();
        Product product = products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
        if (product != null)
        {
            product.setEnergy(this.energy);//обновление ккал


            List<String> productsTemp = FileServiceProduct.convertToList(products);
            FileServiceProduct.overwriteToFile(productsTemp);
        }
        else
        {
            if (this.name != null)
            {
                product = product.createProduct(this.name, this.energy);
                FileServiceProduct.addLineToFile(product);
            }
            else
            {
                System.out.println("Некорректное имя.");
            }
        }
    }
}
