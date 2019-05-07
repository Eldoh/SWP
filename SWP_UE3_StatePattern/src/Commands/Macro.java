package Commands;

import Interfaces.Command;

import java.util.Deque;
import java.util.LinkedList;

public class Macro implements Command {

    Deque<Command> queue;
    Deque<Command> history;

    public Macro(){
        queue = new LinkedList<>();
        history = new LinkedList<>();
    }

    @Override
    public void execute() {
        while(!queue.isEmpty()){
            Command c = queue.pollFirst();
            c.execute();
            history.add(c);
        }
    }

    @Override
    public void undo() {
        while(!history.isEmpty()){
            history.pollLast().undo();
        }
    }

    public void addCommand(Command command){
        queue.add(command);
    }

    public void removeCommand(Command command){
        queue.remove(command);
    }

    public void clearMacro(){
        queue.clear();
    }


}
