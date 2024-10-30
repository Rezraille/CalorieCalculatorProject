package realization;

import Info.CommandInfo;
import command.*;
import command.impl.*;
import Info.CommandType;

import java.util.LinkedHashMap;

public class FactoryCommand
{
    public static Command createCommandByInfo (CommandInfo info)
    {
        String name = info.getName();
        LinkedHashMap<String, String> typeAndValue = info.getTypeAndValue();

        if (name.equals(CommandType.ADD_FOOD.getCommand()))
        {
            return AddFood.create(typeAndValue);
        }
        else if (name.equals(CommandType.ADD_PRODUCT.getCommand()))
        {
            return AddProduct.create(typeAndValue);
        }
        else if (name.equals(CommandType.COUNT_CALORIES_FOOD.getCommand()))
        {
            return CountCaloriesFood.create(typeAndValue);
        }
        else if (name.equals(CommandType.DELETE_FOOD.getCommand()))
        {
            return DeleteFood.create(typeAndValue);
        }
        else if (name.equals(CommandType.DELETE_PRODUCT.getCommand()))
        {
            return DeleteProduct.create(typeAndValue);
        }
        else if (name.equals(CommandType.LIST_OF_FOOD.getCommand()))
        {
            return ListOfFood.create(typeAndValue);
        }
        else if (name.equals(CommandType.LIST_OF_PRODUCT.getCommand()))
        {
            return new ListOfProduct();
        }
    }
}
