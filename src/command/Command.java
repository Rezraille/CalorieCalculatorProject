package command;

import java.io.IOException;
import java.util.LinkedHashMap;

public interface Command
{
    void execute () throws IOException;
}
