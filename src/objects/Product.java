package objects;

import java.time.LocalDate;

public class Product
{
    private Integer index;
    private String name;
    private Integer energy;

    private Product (Integer index, String name, Integer energy)
    {
        this.index = index;
        this.name = name;
        this.energy = energy;
    }

    public Integer getIndex ()
    {
        return index;
    }

    public static Product createProduct (String[] values)
    {
        Integer index = null;
        String name = null;
        Integer energy = null;
        for (int i = 0; i < values.length; i++)
        {
            switch (i)
            {
                case 0: index = Integer.valueOf(values[i]);
                case 1: name = values[i];
                case 2: energy = Integer.valueOf(values[i]);
            }
        }
        return new Product(index,name,energy);
    }
}
