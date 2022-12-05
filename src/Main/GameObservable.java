package Main;

import DataType.GameState;

import java.util.ArrayList;
import java.util.List;

public class GameObservable {


    private List<GameObserver> gameObservers;
    private List<Integer> players;
    private List<String> playersName;

    public GameObservable(){
        gameObservers = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void add(GameObserver observer){
        gameObservers.add(observer);
    }



    public void addPlayer(int playerIdx,String name, GameObserver observer){
        if(players.size()<5){
            players.add(playerIdx);
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


    public List<Integer> getPlayers() {
        return players;
    }

    public List<String> getPlayersName() {
        return playersName;
    }
}
