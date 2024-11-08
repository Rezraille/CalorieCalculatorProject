package command.impl;

import command.Command;
import realization.workingOnFiles.FileServiceProduct;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.LinkedHashMap;

//удалить продукт по индексу продукта
//str: delFood -i - по индексу продукта
//str: delFood -n - по имени продукта
public class DeleteProduct implements Command
{
    private final static String PREFIX_INDEX = "-i";
    private final static String PREFIX_NAME = "-n";
    private Integer index;
    private String name;

    private DeleteProduct (Integer index, String name)
    {
        this.index = index;
        this.name = name;
    }

    public static DeleteProduct create (LinkedHashMap<String, String> typeAndValue)
    {
        String i = typeAndValue.get(PREFIX_INDEX);
        Integer index = i != null ? Integer.valueOf(i) : null;//TODO добавить проверку на число
        String name = typeAndValue.get(PREFIX_NAME);
        //TODO добавить обработку ошибок
        return new DeleteProduct(index, name);
    }

    @Override
    public void execute () throws IOException
    {
        if (name != null && index == null)
        {
            FileServiceProduct.deleteLineByName(name);
        }
        else if (index != null && name == null)
        {
            FileServiceProduct.deleteLineByIndex(index);
        }
        else
        {
            System.out.println("Ошибка ввода index или name.");
        }
    }
}
