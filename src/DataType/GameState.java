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

}
