package DataType;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.HandPosition;
import DataType.Position.SleepingQueenPosition;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GameState {

    public int numberOfPlayers;
    public int onTurn;
    public Set<SleepingQueenPosition> sleepingQueens;
    public Map<HandPosition, Optional<Card>> cards;
    public Map<AwokenQueenPosition, Queen> awokenQueens;
    public List<Card> cardsDiscartedLastTurn;


    @Override
    public String toString(){
        String s = "";
        s+= "on turn: "+ onTurn+"\n";
        s+= "cardsDiscartedLastTurn: "+ cardsDiscartedLastTurn.toString()+"\n";
        s+= "sleepingQueens: "+ sleepingQueens.toString()+"\n";
        s+= "awokenQueens: "+awokenQueens.toString()+"\n";
        return s;
    }
}
