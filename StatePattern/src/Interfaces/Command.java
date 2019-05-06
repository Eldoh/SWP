package Interfaces;

import Game.GameManager;

public interface Command {

    void execute();
    void undo();
}
