package Main;

import DataType.GameState;
import DataType.PlayerState;
import DataType.Position.Position;

import java.util.List;

public class Player {

    private PlayerState playerState;
    private Hand hand;
    private final int playerId;
    private DrawingAndTrashPile drawingAndTrashPile;
    private GameState gameState;
    private AwokenQueens awokenQueens;

    public Player(int playerId, DrawingAndTrashPile drawingAndTrashPile, GameState gameState){
        playerState = new PlayerState();
        awokenQueens = new AwokenQueens();
        this.playerId = playerId;
        this.drawingAndTrashPile = drawingAndTrashPile;
        this.gameState = gameState;
        hand = new Hand(playerId, drawingAndTrashPile, gameState);
    }

    public void play(List<Position> cards){


    }

    public PlayerState getPlayerState(){
        return playerState;
    }

}
