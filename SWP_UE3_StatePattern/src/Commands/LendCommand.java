package Commands;

import Game.GameManager;
import Interfaces.Command;

public class LendCommand implements Command {
    private GameManager gameManager;
    private String gameName;
    private GameManager toGM;

    public LendCommand(GameManager gameManager, String gameName, GameManager toGM){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.lendGame(gameName, toGM);
    }

    @Override
    public void undo() {
        gameManager.requestBack(gameName, true);
    }
}
