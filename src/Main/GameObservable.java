package Main;

import DataType.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameObservable {


    private List<GameObserver> gameObservers;
    private List<Integer> players;

    public GameObservable(){
        gameObservers = new ArrayList<>();
        players = new ArrayList<>();
    }

    void add(GameObserver observer){
        gameObservers.add(observer);
    }



    void addPlayer(int playerIdx, GameObserver observer){
        if(players.size()<5){
            players.add(playerIdx);
            gameObservers.add(observer);
        }
    }


    void remove(GameObserver observer){
        try {
            gameObservers.remove(observer);
        }
        catch (Exception e){
            System.err.println("observer "+observer.toString()+"don't exist");
        }
    }


    void notifyAll(GameState message){

        for (GameObserver gameObserver : gameObservers) {
            gameObserver.notify(String.valueOf(message));
        }

    }

}
