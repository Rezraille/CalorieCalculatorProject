import Info.CommandInfo;
import command.Command;
import realization.FactoryCommand;
import realization.LineParser;

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
