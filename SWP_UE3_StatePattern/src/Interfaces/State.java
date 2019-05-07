package Interfaces;

import Game.*;
public interface State {

    State buy(Game game);
    State download(Game game);
    State play(Game game);
    State stop(Game game);
    State uninstall(Game game);
    State LendTo(Game game);
    State RequestBack(Game game, boolean force);
    State returnBack(Game game);
    State requestFrom(Game game);
    State receive(Game game);

    String getName();
}
