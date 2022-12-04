package DataType;

import Main.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    public Map<Integer, Queen> awokenQueens;

    public PlayerState(){
      awokenQueens = new HashMap<>();
      cards = new HashMap<>();
    }

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }


}
