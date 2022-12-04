package Main;

import DataType.PlayerState;
import DataType.Position.Position;

import java.util.List;

public class Player {

    private PlayerState playerState;
    private Hand hand;
    private final int playerId;
    private DrawingAndTrashPile drawingAndTrashPile;

    public Player(int playerId, DrawingAndTrashPile drawingAndTrashPile){
        playerState = new PlayerState();
        this.playerId = playerId;
        this.drawingAndTrashPile = drawingAndTrashPile;
        hand = new Hand(playerId, drawingAndTrashPile);
    }

    public void play(List<Position> cards){

    }

    public PlayerState getPlayerState(){
        return playerState;
    }

}
