package command.impl;

import command.Command;
import realization.workingOnFiles.FileServiceFood;

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
        Integer index;
        try
        {
            index = i != null ? Integer.valueOf(i) : null;
        }
        catch(NumberFormatException e)
        {
            System.out.println("Некорректный формат числа.");
            return null;
        }
        String name = typeAndValue.get(PREFIX_NAME);
        return new DeleteFood(index,name);
    }
    @Override
    public void execute () throws IOException
    {
        if ((name ==  null && index == null) || (name != null && index != null))
        {
            System.out.println("Ошибка ввода index или name.");
            return;
        }

        if (name != null)
        {
            FileServiceFood.deleteLineByName(name);
        }
        else
        {
            FileServiceFood.deleteLineByIndex(index);
        }
        System.out.println("Удаление приема пищи выполнено успешно.");


    }
}
