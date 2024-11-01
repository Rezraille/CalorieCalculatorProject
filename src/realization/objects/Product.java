package realization.objects;

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

    public String getName ()
    {
        return name;
    }

    public Integer getEnergy ()
    {
        return energy;
    }
    public Integer getIndex ()
    {
        return index;
    }
    @Override
    public String toString ()
    {
        return index + " " + name + " " + energy;
    }
    public String toScvString ()
    {
        return index + ";" + name + ";" + energy;
    }

    public void setName (String name)
    {
        this.name = name;
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
