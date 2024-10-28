package command.impl;

import command.Command;

import java.time.LocalDate;
import java.util.LinkedHashMap;

//вывести табличку о СПИСОК СЪЕДЕННЫХ ПРОДУКТОВ
//str: getFood - за весь период (-d -i -n -w)
//str: getFood -d  - за определенную дату(-d -i -n -w)
public class ListOfFood implements Command
{
    private final static String PREFIX_DATE = "-d";
    private LocalDate date;

    private ListOfFood (LocalDate date)
    {
        this.date = date;
    }
    public static ListOfFood create(LinkedHashMap<String,String> typeAndValue)
    {
        String d = typeAndValue.get(PREFIX_DATE);
        LocalDate date = d != null ? LocalDate.parse(d) : null;
        //TODO ошибку если null
        return new ListOfFood(date);
    }

    @Override
    public void execute ()
    {

    }
}
