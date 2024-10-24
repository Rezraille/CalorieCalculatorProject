import java.sql.Time;

//CommandParser - Обработка строки - Шаблон - Проверка на соответствие шаблону
public class CommandParser
{
    private final String regexForProduct = null;
    private final String regexForMeal = null;
    private String eat;
    private Integer kcalories;
    private Time data;
    private String meal;
    private Integer weight;

    public static CommandName isCommandName (String str)
    {
        String com = parse(str);
        for (CommandName command:CommandName.values())
        {
            if (command.getCommand().equals(com))
            {
                return command;
            }
        }
        return CommandName.ERROR;
    }

    private static String parse (String str)
    {
        String text = str.substring(0,str.indexOf(' '));
        return text;
    }
}
