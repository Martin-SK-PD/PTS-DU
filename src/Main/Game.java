package Main;

import DataType.GameState;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;

import java.util.*;

public class Game {


    private GameState gameState;
    private DrawingAndTrashPile drawingAndTrashPile;
    private ArrayList<Player> players;
    private SleepingQueens sleepingQueens;
    private GameFinished gameFinished;


    public Game(Map<String, Integer> map){

        gameState = new GameState();
        drawingAndTrashPile = new DrawingAndTrashPile();
        sleepingQueens = new SleepingQueens();

        gameState.awokenQueens = new HashMap<>();
        gameState.numberOfPlayers = map.size();
        gameState.onTurn = (int)(Math.random()*(gameState.numberOfPlayers-1) );
        gameState.cardsDiscartedLastTurn = new ArrayList<>();
        Set<SleepingQueenPosition> set = new HashSet<>();
        for(int i = 0; i < 12; i++){
            set.add(new SleepingQueenPosition(i));
        }
        gameState.sleepingQueens = set;


        for (Integer i : map.values()){
            players.add(new Player(i,this));
        }

        gameFinished = new GameFinished();


    }


    public Optional<GameState> play(int playerIdx, List<Position> cards){

        if(playerIdx != gameState.onTurn){
            return  Optional.empty();
        }

        players.get(playerIdx).play(cards);

        gameState.onTurn =  (gameState.onTurn + 1) % gameState.numberOfPlayers;
        gameState.cardsDiscartedLastTurn = drawingAndTrashPile.getCardsDiscardedThisTurn();


        return Optional.of(gameState);
    }

    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }
}
