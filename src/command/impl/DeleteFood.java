package command.impl;

import command.Command;
import realization.workingOnFiles.FileServiceProduct;
import realization.workingOnFiles.FileSirviceFood;

import java.io.IOException;
import java.util.LinkedHashMap;

//удалить прием пищи по индексу приема пищи
//str: delFood -i(food)
public class DeleteFood implements Command
{
    private Integer index;
    private final static String PREFIX_INDEX = "-i";
    private String name;
    private final static String PREFIX_NAME = "-n";

    private DeleteFood (Integer index, String name)
    {
        this.index = index;
        this.name = name;
    }

    public static DeleteFood create(LinkedHashMap<String,String> typeAndValue)
    {
        String i = typeAndValue.get(PREFIX_INDEX);
        Integer index = i != null ? Integer.valueOf(i) : null; //TODO добавить проверку на число
        //TODO добавить обработку ошибок
        String name = typeAndValue.get(PREFIX_NAME);
        return new DeleteFood(index,name);
    }
    @Override
    public void execute () throws IOException
    {
        if (name != null && index == null)
        {
            FileSirviceFood.deleteLineByName(name);
        }
        else if (index != null && name == null)
        {
            FileSirviceFood.deleteLineByIndex(index);
        }
        else
        {
            System.out.println("Ошибка ввода index или name.");
        }
    }
}
