package command.impl;

import command.Command;

import java.time.LocalDate;
import java.util.LinkedHashMap;

//удалить прием пищи по индексу приема пищи
//str: delFood -i
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
    public void execute ()
    {

    }
}
