package realization.objects;

import realization.workingOnFiles.FileServiceMaxValue;

public class Product {
    private Integer index;
    private String name;
    private Integer energy;

    private Product(Integer index, String name, Integer energy) {
        this.index = index;
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public Integer getEnergy() {
        return energy;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return index + " " + name + " " + energy;
    }

    public String toScvString() {
        return index + ";" + name + ";" + energy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(Integer energy)
    {
        this.energy = energy;
    }

    public static Product createProductFromFile(String[] values) //нужно только для создания листа внутрь файла.
    {
        Integer index = Integer.valueOf(values[0]);
        String name = values[1];
        Integer energy = Integer.valueOf(values[2]);

        return new Product(index, name, energy);
    }

    public static Product createProduct(String name, Integer energy) {
        Integer index = FileServiceMaxValue.setMaxIndexProduct();
        return new Product(index, name, energy);
    }
}
