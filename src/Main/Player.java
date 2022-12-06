package Main;

import DataType.Card;
import DataType.GameState;
import DataType.PlayerState;
import DataType.Position.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player {

    private final int playerId;
    private PlayerState playerState;
    private Game game;
    private Hand hand;
    private AwokenQueens awokenQueens;

    public Player(int playerId, Game game){
        this.playerId = playerId;
        this.game = game;

        playerState = new PlayerState();
        awokenQueens = new AwokenQueens();



        hand = new Hand(this);

        playerState = new PlayerState();
        playerState.setAwokenQueens(new HashMap<>());
        Map<Integer, Optional<Card>> map = new HashMap<>();
        for (int i = 0; i < hand.getCards().size();i++){
            map.put(i+1,Optional.of(hand.getCards().get(i)));
        }
        playerState.setCards(map);
    }




    public boolean play(List<Position> cards){

        return false;
    }

    public PlayerState getPlayerState(){
        return playerState;
    }

    public Game getGame() {
        return game;
    }

    public int getPlayerId() {
        return playerId;
    }
}
