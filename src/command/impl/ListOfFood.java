package command.impl;

import command.Command;
import java.time.format.DateTimeParseException;
import realization.objects.Food;
import realization.workingOnFiles.FileServiceFood;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

//вывести табличку о СПИСОК СЪЕДЕННЫХ ПРОДУКТОВ
//не содержит в файле количество каллорий
//str: getFood - за текущую (-i -d -n -w)
//str: getFood -d  - за определенную дату(-i -d -n -w)
public class ListOfFood implements Command
{
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final static String PREFIX_DATE = "-d";
    private LocalDate date;
    private ListOfFood (LocalDate date)
    {
        this.date = date;
    }
    public static ListOfFood create(LinkedHashMap<String,String> typeAndValue)
    {
        String d = typeAndValue.get(PREFIX_DATE);
        LocalDate date;
        try
        {
            date = d != null ? LocalDate.parse(d,formatter) : null;
        }
        catch (DateTimeParseException e)
        {
            System.out.println("Некорректный формат даты.");
            return null;
        }
        return new ListOfFood(date);
    }

    @Override
    public void execute ()
    {
        List<Food> foodList = FileServiceFood.getListFoodFromFile();
        if (date == null)
        {
            date=LocalDate.now();

        }
        foodList = foodList.stream()
                .filter(f -> f.getDate().equals(date))
                .toList();
        for (Food food : foodList)
        {
            System.out.println(food.toString());
        }
    }
}
