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
        prepare();
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextLine())
        {

            String text = scanner.nextLine();
            if (text.equals("stop"))
            {
                scanner.close();
                break;
            }
            CommandInfo info = LineParser.parse(text);
            Command command = FactoryCommand.createCommandByInfo(info);
            if (command == null)
            {
                continue;
            }
            command.execute();
        }

    }

    private static void prepare()
    {
        //TODO проверить есть ли нужные файл, если нет то создать
    }
}
