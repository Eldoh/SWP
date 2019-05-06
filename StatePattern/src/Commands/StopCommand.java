package Commands;

import Game.GameManager;
import Interfaces.Command;

public class StopCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public StopCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.stopGame(gameName);
    }

    @Override
    public void undo() {
        gameManager.playGame(gameName);
    }


}
