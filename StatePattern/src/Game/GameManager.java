package Game;

import java.util.HashMap;
import java.util.Map;

public class GameManager {

//    private static GameManager gameManager;
    private int gmId;
    private HashMap<String,Game> allGames;

    public GameManager(int id){
        this.gmId = id;
        allGames = new HashMap<>();
        allGames.put("MyGame", new Game("MyGame", this));
        allGames.put("MyGame1", new Game("MyGame1", this));
        allGames.put("MyGame2", new Game("MyGame2", this));
        allGames.put("MyGame3", new Game("MyGame3", this));

    }

//    public static Game.GameManager getInstance(){
//        if(gameManager == null){
//            gameManager = new Game.GameManager();
//        }
//        return gameManager;
//    }

    public void listGames(){
        System.out.println("-------------------------------------");
        System.out.println("Game Manager: "+ gmId);
        allGames.forEach((k,v)->
                System.out.println(v.getGameName() + " / State: " + v.getCurrentState()));
        System.out.println("-------------------------------------");
    }

    public void buyGame(String name){
        if(checkExistence(name)){
            allGames.get(name).buy();
        }
    }

    public void downloadGame(String name){
        if(checkExistence(name)){
            allGames.get(name).download();
        }
    }

    public void playGame(String name){
        if(checkExistence(name) && !isAGameRunning()){
            allGames.get(name).play();
        }
    }

    public void stopGame(String name){
        if(checkExistence(name)){
            allGames.get(name).stop();
        }
    }

    public void uninstallGame(String name){
        if(checkExistence(name)){
            allGames.get(name).uninstall();
        }
    }

    public void lendGame(String name, GameManager gm){
        if(checkExistence(name)){
            allGames.get(name).setLentTo(gm);
            allGames.get(name).lendTo(gm);
            if(allGames.get(name).getCurrentState().equals("Lent")){
                gm.receiveGame(name, this);
            }else{
                allGames.get(name).setLentTo(null);
            }

        }
    }

    public void borrowGame(String name, GameManager gm, boolean answer){
        if(checkExistence(name) && answer){
            allGames.get(name).setOwner(gm);
            allGames.get(name).setLentTo(this);
            allGames.get(name).borrowFrom(gm);
            if(!allGames.get(name).getCurrentState().equals("Playable")){
                System.out.println("This Player can't borrow you this Game at the moment");
                allGames.get(name).setOwner(this);
            }
        }else{
            System.out.println("Request was declined");
        }
    }

    public void requestBack(String name, boolean force){
        if(checkExistence(name)){
            allGames.get(name).requestBack(force);
        }
    }

    public void returnGame(String name){
        if(checkExistence(name)){
            allGames.get(name).returnBack();
            allGames.get(name).setOwner(this);
        }
    }

    public void receiveGame(String name, GameManager gm){
        if(checkExistence(name)){
            allGames.get(name).setOwner(gm);
            allGames.get(name).setLentTo(this);
            allGames.get(name).receive();

        }
    }

    public void receiveGameBack(String name){
        if(checkExistence(name)){
            allGames.get(name).setOwner(this);
            allGames.get(name).setLentTo(null);
            allGames.get(name).receive();

        }
    }



    private boolean checkExistence(String name){
        if(allGames.containsKey(name)){
            return true;
        }else{
            System.out.println("Game ["+ name +"] does not Exist");
            return false;
        }
    }

    public Game getGame(String name){
        if(checkExistence(name)){
            return allGames.get(name);
        }
        return null;
    }

    private boolean isAGameRunning(){
        for(Map.Entry<String, Game> entry : allGames.entrySet()){
            if(entry.getValue().getCurrentState().equals("Running")){
                System.out.println("Another Game is currently running");
                return true;
            }
        }
        return false;
    }

    public int getGmId(){
        return gmId;
    }
}
