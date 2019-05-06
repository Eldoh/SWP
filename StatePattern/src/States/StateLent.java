package States;

import Game.* ;
import Interfaces.State;

public class StateLent implements State {

    private String name ="Lent";

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
        System.out.println(game.getGameName() + " is lent away");
        return this;
    }

    @Override
    public State stop(Game game) {
        System.out.println(game.getGameName() + " is not running");
        return this;
    }

    @Override
    public State uninstall(Game game) {
        System.out.println(game.getGameName() + " is lent away");
        return this;
    }

    @Override
    public State LendTo(Game game) {
        System.out.println(game.getGameName() + " is lent away");
        return this;
    }

    @Override
    public State RequestBack(Game game, boolean force) {
        if(force){
            game.getLentTo().returnGame(game.getGameName());
            return new StatePlayable();
        }
        System.out.println("Return Request for" + game.getGameName() + "has been sent");
        return this;
    }

    @Override
    public State returnBack(Game game) {
        System.out.println(game.getGameName() + " is not borrowed");
        return this;
    }

    @Override
    public State requestFrom(Game game) {
        System.out.println(game.getGameName() + " is already owned");
        return this;
    }

    @Override
    public State receive(Game game) {
        System.out.println(game.getGameName() + " was returned to you");
        return new StatePlayable();
    }

}
