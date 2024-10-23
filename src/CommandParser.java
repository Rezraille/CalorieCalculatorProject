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

    private static boolean isFoodProduct (String str)
    {
        return false;
    }

    private static boolean isMeal (String str)
    {
        return false;
    }

    private static Comanda parse (String sample)
    {
        if (isMeal(sample))
        {
            return new DataProcessing(sample);
        }
        else if (isFoodProduct(sample))
        {
            return null;
        }
        else
        {
            throw new RuntimeException(); //выдавать мою собственную ошибку!!!
        }
    }
}
