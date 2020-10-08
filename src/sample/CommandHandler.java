package sample;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler
{
    List<Command> commandsList = new ArrayList<Command>();

    public void addToList(Command command)
    {
        commandsList.add(command);
    }
    public void removeFromList(Command command)
    {
        commandsList.remove(command);
    }
    public void unexecutedCommandToIndex(int index)
    {
        if(index <= commandsList.size())
        {
            while(commandsList.size() >= index)
            {
                Command target = commandsList.get(commandsList.size() - 1);
                target.unexecute();
                commandsList.remove(target);
            }
        }
    }
    
}