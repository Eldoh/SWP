package Commands;

import Game.GameManager;
import Interfaces.Command;
import States.StateDownloadable;

public class DownloadCommand implements Command {
    private GameManager gameManager;
    private String gameName;

    public DownloadCommand(GameManager gameManager, String gameName){
        this.gameManager = gameManager;
        this.gameName = gameName;
    }

    @Override
    public void execute() {
        gameManager.downloadGame(gameName);
    }

    @Override
    public void undo() {
        gameManager.uninstallGame(gameName);
    }
}
