package Commands;

import Game.GameManager;
import Interfaces.Command;

public class PlayCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public PlayCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.playGame(gameName);
    }

    @Override
    public void undo() {
        gameManager.stopGame(gameName);
    }
}
