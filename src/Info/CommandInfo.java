package Info;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandInfo
{
    private String name;
    private LinkedHashMap<String,String> typeAndValue = null;
    public CommandInfo (String name, LinkedHashMap <String,String> typeAndValue)
    {
        this.name = name;
        this.typeAndValue = typeAndValue;
    }

    public String getName ()
    {
        return name;
    }

    public LinkedHashMap<String, String> getTypeAndValue ()
    {
        return typeAndValue;
    }
}
