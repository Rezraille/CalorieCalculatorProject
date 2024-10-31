package command.impl;

import command.Command;
import realization.objects.Product;
import realization.workingOnFiles.FileServiceProduct;

import java.util.ArrayList;
import java.util.List;

//вывести табличку о ПРОДУКТАХ
//str: getProd - за весь период (-i -n -e)
public class ListOfProduct implements Command
{
    private List<Product> productList = new ArrayList<>();

    @Override
    public void execute ()
    {
        productList = FileServiceProduct.getProductsFromFile();
        for (Product product : productList)
        {
            System.out.println(product.toString());
        }
        //TODO СЧИТАТЬ ПУТЬ К ФАЙЛУ
        //TODO СЧИТАТЬ ДАННЫЕ
        //TODO ВЫВЕСТИ ДАННЫЕ В КОНСОЛЬ
        //TODO ИНАЧЕ - НАПИСАТЬ ЧТО ДАННЫХ НЕТ
    }
}
