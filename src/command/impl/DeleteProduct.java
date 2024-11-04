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
        if (index != null)
        {
            FileServiceProduct.deleteLineByIndex(index);
        }
        else if (name != null)
        {
            FileServiceProduct.deleteLineByName(name);
        }
        else
        {
            System.out.println("Не введено имени или индекса для удаления.");
        }
    }
}
