import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    //Первоначальная продуманная мной структура калькулятора  в файлу "Структура работы".
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = null;
        CommandInfo commandInfo;
        while (scanner.hasNextLine())
        {
            text = scanner.nextLine();
            commandInfo = LineParser.parse(text);
            System.out.println(commandInfo);
        }
    }
}
