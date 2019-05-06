package Commands;

import Game.GameManager;
import Interfaces.Command;

public class ListCommand implements Command {

    private GameManager gameManager;

    public ListCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void execute() {
        gameManager.listGames();
    }

    @Override
    public void undo() {

    }
}
