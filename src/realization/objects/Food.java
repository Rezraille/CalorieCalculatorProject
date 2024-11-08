package realization.objects;

import realization.workingOnFiles.FileServiceMaxValue;

import java.time.LocalDate;

public class Food
{
    private Integer index;
    private LocalDate date;
    private String name;

    private Integer weight;

    private Food (Integer index, LocalDate date, String name, Integer weight)
    {
        this.index = index;
        this.date = date;
        this.name = name;
        this.weight = weight;
    }

    public Integer getIndex ()
    {
        return index;
    }

    public LocalDate getDate ()
    {
        return date;
    }

    public String getName ()
    {
        return name;
    }

    public Integer getWeight ()
    {
        return weight;
    }

    @Override
    public String toString ()
    {
        return index + " " + date + " " + name + " " + weight;
    }
    public String toScvString ()
    {
        return index + ";" + date + ";" + name + ";" + weight;
    }

    public static Food createFoodFromFile(String[] values) // может быть этот метод должен быть в классе фуд?
    {
        Integer index =  Integer.valueOf(values[0]);
        LocalDate date = LocalDate.parse(values[1]);
        String name = values[2];
        Integer weight = Integer.valueOf(values[3]);

        return new Food(index,date,name,weight);
    }
    public static Food createFood (LocalDate date, String name, Integer weight)
    {
        Integer index = FileServiceMaxValue.setMaxIndexFood();
        return new Food(index, date, name, weight);
    }
}
