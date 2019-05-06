package Commands;

import Game.GameManager;
import Interfaces.Command;

public class BorrowCommand implements Command {

    private GameManager gameManager;
    private String gameName;
    private GameManager fromGM;

    public BorrowCommand(GameManager gameManager, String gameName, GameManager fromGM){
        this.gameManager = gameManager;
        this.gameName = gameName;
        this.fromGM = fromGM;
    }

    @Override
    public void execute() {
        gameManager.borrowGame(gameName, fromGM, true);
    }

    @Override
    public void undo() {
        gameManager.returnGame(gameName);
    }
}
