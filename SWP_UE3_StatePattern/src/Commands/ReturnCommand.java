package Commands;

import Game.GameManager;
import Interfaces.Command;

public class ReturnCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public ReturnCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.returnGame(gameName);
    }

    @Override
    public void undo() {
        System.out.println("This Command can't be undone");
    }
}
