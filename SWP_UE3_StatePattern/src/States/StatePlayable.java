package States;

import Game.*;
import Interfaces.State;

public class StatePlayable implements State {

    private String name ="Playable";

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
        System.out.println(game.getGameName() + " started");
        return new StateRunning();
    }

    @Override
    public State stop(Game game) {
        System.out.println(game.getGameName() + " is not Running");
        return this;
    }

    @Override
    public State uninstall(Game game) {
        System.out.println(game.getGameName() + " uninstalled");
        return new StateDownloadable();
    }

    @Override
    public State LendTo(Game game) {
        System.out.println(game.getGameName() + " lend to "+ game.getLentTo().getGmId());
        return new StateLent();
    }

    @Override
    public State RequestBack(Game game, boolean force) {
        System.out.println(game.getGameName() + " is not lent away");
        return this;
    }

    @Override
    public State returnBack(Game game) {
        if(game.getLentTo() != null){
            game.setLentTo(null);
            game.getOwner().receiveGameBack(game.getGameName());
            System.out.println(game.getGameName() + " returned to " +game.getOwner());
            return new StateAvailable();
        }else{
            System.out.println(game.getGameName() + " is not borrowed");
            return this;
        }
    }

    @Override
    public State requestFrom(Game game) {
        System.out.println(game.getGameName() + " is already Playable");
        return this;
    }

    @Override
    public State receive(Game game) {
        System.out.println(game.getGameName() + " already Playable");
        return this;
    }

}
