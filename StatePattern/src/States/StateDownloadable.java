package States;

import Game.*;
import Interfaces.State;

public class StateDownloadable implements State {

    private String name ="Downloadable";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public State buy(Game game) {
        System.out.println(game.getGameName() + " already owned");
        return this;
    }

    @Override
    public State download(Game game) {
        System.out.println("Downloading " + game.getGameName() + " ...");
        System.out.println("Download complete");
        return new StatePlayable();
    }

    @Override
    public State play(Game game) {
        System.out.println(game.getGameName() + " is not Installed");
        return this;
    }

    @Override
    public State stop(Game game) {
        System.out.println(game.getGameName() + " is not Running");
        return this;
    }

    @Override
    public State uninstall(Game game) {
        System.out.println(game.getGameName() + " is not Installed");
        return this;
    }

    @Override
    public State LendTo(Game game) {
        System.out.println(game.getGameName() + " is not Installed");
        return this;
    }

    @Override
    public State RequestBack(Game game, boolean force) {
        System.out.println(game.getGameName() + " is not Installed");
        return this;
    }

    @Override
    public State returnBack(Game game) {
        System.out.println(game.getGameName() + " is not Borrowed");
        return this;
    }

    @Override
    public State requestFrom(Game game) {
        System.out.println(game.getGameName() + " is already owned");
        return this;
    }

    @Override
    public State receive(Game game) {
        System.out.println(game.getGameName() + " is already owned");
        return this;
    }
}
