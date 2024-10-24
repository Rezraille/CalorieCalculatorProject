import java.util.Scanner;

public class Main
{
    //Первоначальная продуманная мной структура калькулятора  в файлу "Структура работы".
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = null;
        CommandName comanda;
        while (scanner.hasNextLine())
        {
            text = scanner.nextLine();
            comanda = CommandParser.isCommandName(text);
            System.out.println(comanda);
        }
    }
}
