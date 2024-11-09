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
    @Override
    public void execute ()
    {
        List<Product> productList = FileServiceProduct.getListProductFromFile();
        for (Product product : productList)
        {
            System.out.println(product.toString());
        }
    }
}
