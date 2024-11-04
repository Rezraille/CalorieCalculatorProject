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
    private final static String PREFIX_INDEX = "-i";
    private Integer index;

    private DeleteFood (Integer index)
    {
        this.index = index;
    }

    public static DeleteFood create(LinkedHashMap<String,String> typeAndValue)
    {

        Integer index = Integer.valueOf(typeAndValue.get(PREFIX_INDEX));//TODO добавить проверку на число
        //TODO добавить обработку ошибок
        return new DeleteFood(index);
    }
    @Override
    public void execute () throws IOException
    {
        if (index != null)
        {
            FileSirviceFood.deleteLineByIndex(index);
        }
        else
        {
            System.out.println("Не введено индекса для удаления.");
        }
    }
}
