package command.impl;

import command.Command;

import java.util.LinkedHashMap;

//добавить продукт, если он уже есть, то обновить ккал
//str: addProd -n мандарин -e 45
public class AddProduct implements Command
{
    private final static String PREFIX_NAME = "-n";
    private final static String PREFIX_ENERGY = "-e";

    private String name;

    private Integer energy;

    private AddProduct (String name, Integer energy)
    {
        this.name = name;
        this.energy = energy;
    }


    public static AddProduct create(LinkedHashMap<String,String> typeAndValue)
    {

        String name = typeAndValue.get(PREFIX_NAME);
        Integer energy = Integer.valueOf(typeAndValue.get(PREFIX_ENERGY));//TODO добавить проверку на число
        //TODO ошибку если null


        return new AddProduct(name,energy);
    }
    @Override
    public void execute ()
    {

    }
}
