package command.impl;

import command.Command;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
// добавить прием пищи - кушать
//str: addFood -d 24.02.2022 -i 12 -n торт -w 100 -e 186

//str: addFood -i 12 -n торт -w 100 -e 186 +
//str: addFood -i 12 -n торт -w 100 +
//str: addFood -i 12 -w 100 +

//str: addFood -d 24.02.2022 -n торт -w 100 -e 186 +
//str: addFood -n торт -w 100 -e 186 +
//str: addFood -n торт -w 100 +
public class AddFood implements Command
{
    private final static String PREFIX_DATE = "-d";
    private final static String PREFIX_INDEX = "-i";
    private final static String PREFIX_NAME = "-n";
    private final static String PREFIX_WEIGHT = "-w";
    private final static String PREFIX_ENERGY = "-e";
    private LocalDate date;
    private Integer index;
    private String name;

    private Integer weight;

    private Integer energy;

    private AddFood(LocalDate date, Integer index, String name, Integer weight, Integer energy)
    {
        this.date = date;
        this.index = index;
        this.name = name;
        this.weight = weight;
        this.energy = energy;
    }

    public static AddFood create(LinkedHashMap<String,String> typeAndValue)
    {

        String d = typeAndValue.get(PREFIX_DATE);
        LocalDate date = d != null ? LocalDate.parse(d) : null;
        String i = typeAndValue.get(PREFIX_DATE);
        Integer index = i != null ? Integer.valueOf(i) : null; //TODO добавить проверку на число
        String name = typeAndValue.get(PREFIX_DATE);
        String w = typeAndValue.get(PREFIX_WEIGHT);
        Integer weight = w != null ? Integer.valueOf(w) : null; //TODO добавить проверку на число
        String e = typeAndValue.get(PREFIX_ENERGY);
        Integer energy = e != null ? Integer.valueOf(e) : null; //TODO добавить проверку на число
        //TODO добавить обработку ошибок
        return new AddFood(date, index, name, weight, energy);
    }

    @Override
    public void execute ()
    {
        if (date == null)
        {
            date = LocalDate.now();
        }



    }

}
