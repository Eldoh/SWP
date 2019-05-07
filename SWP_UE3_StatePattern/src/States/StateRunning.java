package States;

import Game.*;
import Interfaces.State;

public class StateRunning implements State {

    private String name ="Running";

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
        System.out.println(game.getGameName() + " already downloaded");
        return this;
    }

    @Override
    public State play(Game game) {
        System.out.println(game.getGameName() + " already running");
        return this;
    }

    @Override
    public State stop(Game game) {
        System.out.println(game.getGameName() + " stopped");
        return new StatePlayable();
    }

    @Override
    public State uninstall(Game game) {
        System.out.println(game.getGameName() + " is running, please stop before uninstalling");
        return this;
    }

    @Override
    public State LendTo(Game game) {
        System.out.println(game.getGameName() + " is running, please stop before trying to lend");
        return this;
    }

    @Override
    public State RequestBack(Game game, boolean force) {
        System.out.println(game.getGameName() + " is not lent");
        return this;
    }

    @Override
    public State returnBack(Game game) {
        if(game.getLentTo() != null){
            System.out.println(game.getGameName() + " was stopped because the owner force-requested it back");
            game.setLentTo(null);
            game.getOwner().receiveGameBack(game.getGameName());

            return new StateAvailable();
        }else{
            System.out.println(game.getGameName() + " is not borrowed");
            return this;
        }
    }

    @Override
    public State requestFrom(Game game) {
        System.out.println(game.getGameName() + " is running");
        return this;
    }

    @Override
    public State receive(Game game) {
        System.out.println(game.getGameName() + " is running");
        return this;
    }

}
