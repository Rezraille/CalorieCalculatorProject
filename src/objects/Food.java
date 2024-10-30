package objects;

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

    public static Food createFood (String[] values) // может быть этот метод должен быть в классе фуд?
    {
        Integer index = null;
        LocalDate date = null;
        String name = null;
        Integer weight = null;
        for (int i = 0; i < values.length; i++)
        {
            switch (i)
            {
                case 0: index = Integer.valueOf(values[i]);
                case 1: date = LocalDate.parse(values[i]);
                case 2: name = values[i];
                case 3: weight = Integer.valueOf(values[i]);

            }
        }
        return new Food(index,date,name,weight);
    }
}
