import java.util.Map;

public class CommandInfo
{
    private String name;
    private Map<String,String> typeAndValue = null;
    public CommandInfo (String name, Map <String,String> typeAndValue)
    {
        this.name = name;
        this.typeAndValue = typeAndValue;
    }
}
