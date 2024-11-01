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
        Integer energy = Integer.valueOf(typeAndValue.get(PREFIX_ENERGY));//TODO добавить проверку на число
        //TODO ошибку если null


        return new AddProduct(name, energy);
    }

    @Override
    public void execute ()
    {
        List<Product> products = FileServiceProduct.getListProductFromFile();
        Boolean isEqualse = false;
        for (Product product : products)
        {
            if (product.getName().equals(name))
            {
                product.setName(name);
                isEqualse = true;
            }
            else
            {
                //TODO FileServiceProduct.addLineToFile(product);
            }
        }
        if (isEqualse)
        {
            List<String> productsTemp = FileServiceProduct.convertToList(products);
            FileServiceProduct.overwriteToFile(productsTemp);
        }
        //TODO ПРОВЕРИТЬ ИМЯ И ККАЛ НА NULL
        //TODO ВВЕСТИ ПУТЬ
        //TODO СЧИТАТЬ ВСЕ ДАННЫЕ С КОНСОЛИ
        //TODO СДЕЛАТЬ ИНДЕКС И УВЕЛИЧИВАТЬ ЕГО ПОСЛЕ КАЖДОГО СОЗДАНИЯ КОМАНДЫ ИЛИ ПОСЛЕ КАЖДОГО УСПЕШНОГО ДОБАВЛЕНИЯ ДАННЫХ В ФАЙЛ
        //TODO ДОБАВИТЬ ВСЕ ДАННЫЕ В ФАЙЛ ПРОДУКТОВ
    }
}
