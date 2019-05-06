package Game;

import Interfaces.State;
import States.StateAvailable;
import Game.GameManager;

public class Game {

    private GameManager owner;      // gmId
    private GameManager lentTo;     // gmId
    private State currentState;
    private String gameName;

    public Game(String name, GameManager gameManager){
        currentState = new StateAvailable();
        gameName = name;
        owner = gameManager;
        lentTo = null;
    }

    public void buy(){
        currentState = currentState.buy(this);
    }

    public void download(){
        currentState = currentState.download(this);
    }

    public void play(){
        currentState = currentState.play(this);
    }

    public void stop(){
        currentState = currentState.stop(this);
    }

    public void uninstall(){
        currentState = currentState.uninstall(this);
    }

    public void lendTo(GameManager gm){
        currentState = currentState.LendTo(this);
    }

    public void borrowFrom(GameManager gm){
        currentState = currentState.requestFrom(this);
    }

    public void requestBack(boolean force){
        currentState = currentState.RequestBack(this, force);
    }

    public void returnBack(){
        currentState = currentState.returnBack(this);
    }

    public void receive(){
        currentState = currentState.receive(this);
    }





    public GameManager getOwner() {
        return owner;
    }

    public void setOwner(GameManager owner) {
        this.owner = owner;
    }

    public GameManager getLentTo() {
        return lentTo;
    }

    public void setLentTo(GameManager lentTo) {
        this.lentTo = lentTo;
    }

    public String getCurrentState() {
        return currentState.getName();
    }

    public String getGameName(){
        return gameName;
    }

    public void setState(State state){
        this.currentState = state;
    }
}
