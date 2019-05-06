package Commands;

import Game.GameManager;
import Interfaces.Command;
import States.StateAvailable;

public class BuyCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public BuyCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.buyGame(gameName);
    }

    @Override
    public void undo() {
        gameManager.getGame(gameName).setState(new StateAvailable());
    }

}
