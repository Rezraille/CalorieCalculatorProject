package realization;

import Info.CommandInfo;

import java.util.LinkedHashMap;

//LineParser - Обработка строки - Шаблон - Проверка на соответствие шаблону
public class LineParser
{
    //private final String regexForValue = "\\d+";
    //private final String regexForValueType = "\\-[dinwe]";
    //private final String separator = " ";
    //private String eat;
    //private Integer kcalories;
    //private Time data;
    //private String meal;
    //private Integer weight;


    public static CommandInfo parse (String str)
    {
        LinkedHashMap<String, String> typeAndValue = new LinkedHashMap<>();
        String command = str.substring(0, str.indexOf(' '));
        str = str.substring(str.indexOf(' ') + 1);
        String[] parametr = str.split(" ");
        if (parametr.length % 2 == 0)
        {
            for (int i = 1; i < parametr.length; i += 2)
            {
                typeAndValue.put(parametr[i - 1], parametr[i]);
            }
        }
        else
        {
            return null;
        }
        return new CommandInfo(command, typeAndValue);
    }
    public static String[] parseLineFile (String line)
    {
        return line.split(";");
    }
}
