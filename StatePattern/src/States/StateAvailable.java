package States;

import Interfaces.State;
import Game.*;

public class StateAvailable implements State {

    private final String name ="Available";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public State buy(Game game) {
        System.out.println(game.getGameName() + " bought");
        return new StateDownloadable();
    }

    @Override
    public State download(Game game) {
        System.out.println("Buy" + game.getGameName() + " first");
        return this;
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
        System.out.println(game.getGameName() + " is not Owned");
        return this;
    }

    @Override
    public State RequestBack(Game game, boolean force) {
        System.out.println(game.getGameName() + " is not Owned");
        return this;
    }

    @Override
    public State returnBack(Game game) {
        System.out.println(game.getGameName() + " is not Owned");
        return this;
    }

    @Override
    public State requestFrom(Game game) {
        game.getOwner().lendGame(game.getGameName(), game.getLentTo());
        if(game.getCurrentState().equals("Playable")){
            return new StatePlayable();
        }

        return this;
    }

    @Override
    public State receive(Game game) {
        System.out.println(game.getGameName() + " borrowed");
        return new StatePlayable();
    }


}
