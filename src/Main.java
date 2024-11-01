import Info.CommandInfo;
import command.Command;
import realization.FactoryCommand;
import realization.LineParser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static void main (String[] args) throws IOException
    {
        LocalDate date = LocalDate.now();
        System.out.println(date);
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
