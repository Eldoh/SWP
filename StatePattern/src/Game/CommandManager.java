package Game;

import Interfaces.Command;

import java.util.Deque;
import java.util.LinkedList;

public class CommandManager {

    Deque<Command> stack;
    Deque<Command> history;

    public CommandManager(){
        stack = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void execute(int anzahl) {
        if(anzahl==0){
            while(!stack.isEmpty()){
                Command c = stack.pollFirst();
                c.execute();
                history.add(c);
            }
        }else{
            for(int i = 0; i<anzahl; i++){
                Command c = stack.pollFirst();
                c.execute();
                history.add(c);
            }
        }
    }

    public void undo(int anzahl) {
        if(anzahl==0){
            while(!history.isEmpty()){
                history.pollLast().undo();
            }
        }else{
            for(int i = 0; i<anzahl; i++){
                history.pollLast().undo();
            }
        }
    }

    public void addCommand(Command command){
        stack.add(command);
    }

    public void removeCommand(Command command){
        stack.remove(command);
    }

    public void clear(){
        stack.clear();
    }
}
