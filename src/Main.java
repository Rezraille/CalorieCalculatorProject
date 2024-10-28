import command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine())
        {
            String text = scanner.nextLine();
            CommandInfo info = LineParser.parse(text);
            Command command = FactoryCommand.createCommandByInfo(info);
            command.execute();

        }
    }
}
