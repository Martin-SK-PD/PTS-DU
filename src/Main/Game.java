package Main;

import DataType.GameState;
import DataType.Position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {


    private GameState gameState;
    private DrawingAndTrashPile drawingAndTrashPile;
    private ArrayList<Player> players;

    public Game(){
        players = new ArrayList<>();
        gameState = new GameState();
        drawingAndTrashPile = new DrawingAndTrashPile();
    }


    public Optional<GameState> play(int playerIdx, List<Position> cards){

        players.get(playerIdx).play(cards);

        gameState.onTurn =  (gameState.onTurn + 1) % gameState.numberOfPlayers;
        gameState.cardsDiscartedLastTurn = drawingAndTrashPile.getCardsDiscardedThisTurn();
        
        return Optional.of(gameState);
    }
}
