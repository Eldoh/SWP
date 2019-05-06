package Commands;

import Game.GameManager;
import Interfaces.Command;

public class UninstallCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public UninstallCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.uninstallGame(gameName);
    }

    @Override
    public void undo() {
        gameManager.downloadGame(gameName);
    }

}
