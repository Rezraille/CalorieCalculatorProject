package command.impl;

import command.Command;

import java.time.LocalDate;
import java.util.LinkedHashMap;

//вывести табличку о СПИСОК СЪЕДЕННЫХ ПРОДУКТОВ
//не содержит в файле количество каллорий
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
        //TODO ЕСЛИ ДАТА УКАЗАНА
        //TODO СЧИТАТЬ ПУТЬ
        //TODO ВЫПОЛНИТЬ ПОИСК ДАТЫ ПО ФАЙЛУ
        //TODO ЕСЛИ ДАТА ЕСТЬ
        //TODO СЧИТАТЬ ДАННЫЕ С УКАЗАНИЕМ ДАТЫ
        //TODO ВЫВЕСТИ СТРОКИ С УКАЗАННОЙ ДАТОЙ
        //TODO ЕСЛИ ДАТЫ НЕТ ВЫВЕСТИ - ДАТЫ НЕТ

        //TODO ЕСЛИ ДАТА НЕ УКАЗАНА
        //TODO СЧИТАТЬ ПУТЬ
        //TODO СЧИТАТЬ ДАННЫЕ
        //TODO ВЫВЕСТИ СТРОКИ
    }
}
