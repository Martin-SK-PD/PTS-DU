package Main;

import DataType.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameObservable {

    private List<GameObserver> gameObservers;
    private List<String> playersName;

    public GameObservable(){
        gameObservers = new ArrayList<>();
        playersName = new ArrayList<>();
    }

    public void add(GameObserver observer){
        if(!gameObservers.contains(observer)) {
            gameObservers.add(observer);
        }
    }



    public void addPlayer(String name, GameObserver observer){
        if(playersName.size()<5 && !playersName.contains(name)){
            playersName.add(name);
            gameObservers.add(observer);
        }
    }


    public void remove(GameObserver observer){
        try {
            gameObservers.remove(observer);
        }
        catch (Exception e){
            System.err.println("observer "+observer.toString()+"don't exist");
        }
    }


    public void notifyAll(GameState message){

        for (GameObserver gameObserver : gameObservers) {
            gameObserver.notify(message.toString());
        }

    }



    public List<String> getPlayersName() {
        return playersName;
    }


    //for testing

    public List<GameObserver> getGameObservers() {
        return gameObservers;
    }


}
