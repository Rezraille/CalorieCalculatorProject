package command.impl;

import command.Command;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;

//посчитать и вывести в консоль сколько калорий съедено сегодня
//str: getCal - сегодня
//str: getCal -d - за определенную дату
public class CountCaloriesFood implements Command
{
    private final static String PREFIX_DATE = "-d";
    private LocalDate date;
    private CountCaloriesFood (LocalDate date)
    {
        this.date = date;
    }


    public static CountCaloriesFood create(LinkedHashMap<String,String> typeAndValue)
    {

        String d = typeAndValue.get(PREFIX_DATE);
        LocalDate date = d != null ? LocalDate.parse(d) : null;
        //TODO добавить обработку ошибок
        return new CountCaloriesFood(date);
    }
    @Override
    public void execute ()
    {
        if (date == null)
        {
            date = LocalDate.now();
            date = LocalDate.now();
        }
        //TODO ПРОВЕРИТЬ ДАТУ НА NULL ЕСЛИ NULL - ПРИСВОИТЬ ТЕКУЩУЮ
        //TODO ЕСЛИ ДАТА НЕ NULL
        //TODO ВВЕСТИ ПУТЬ
        //TODO СЧИТАТЬ ВСЕ ДАННЫЕ ПО ДАТЕ СО ФАЙЛА ПРИЕМОВ ПИЩИ
        //TODO ПООЧЕРЕДНО ПОЛУЧИТЬ ВЕС ПИЩИ
        //TODO ИЩЕМ ПООЧЕРЕДНО ПО ИМЕНИ(НАПРИМЕР) ПРИЕМА ПИЩИ В ФАЙЛЕ СПИСОК ПРОДУКТОВ ПРОДУКТ
        //TODO ЗАПИСЫВАЕМ ЗНАЧЕНИЕ ККАЛ ПРОДУКТА НА 100 ГР
        //TODO СОЗДАТЬ КОНСТАНТУ ВЕС 100ГР ДЛЯ ПОДАНЫХ ККАЛ
        //TODO ПОСЧИТАТЬ КАЖДУЮ ПИЩУ === ККАЛ ПИЩИ = (ГР ПИЩИ * ККАЛ ПРОДУКТА)/100ГР ПРОДУКТА
        //TODO СУММИРОВАТЬ ВСЕ ПИЩИ И ВЫВЕСТИ СУММУ В КОНСОЛЬ

    }
}
