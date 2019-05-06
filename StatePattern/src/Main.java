import Commands.*;
import Game.CommandManager;
import Game.GameManager;
import Interfaces.Command;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) {

        GameManager gameManager1 = new GameManager(1);
        GameManager gameManager2 = new GameManager(2);

        CommandManager cm = new CommandManager();
//        Deque<Command> stack = new LinkedList<>();
//        Deque<Command> history = new LinkedList<>();

        Command listCommand = new ListCommand(gameManager1);

        listCommand.execute();
        Macro m = new Macro();
        m.addCommand(new BuyCommand(gameManager1,"MyGame1"));
        m.addCommand(new DownloadCommand(gameManager1,"MyGame1"));
        m.addCommand(new PlayCommand(gameManager1,"MyGame1"));

        cm.addCommand(m);
        cm.addCommand(new BuyCommand(gameManager2, "MyGame"));
        cm.execute(1);

        listCommand.execute();
        cm.undo(1);
        listCommand.execute();

    }
}
