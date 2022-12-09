package DataType;

import Main.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    public Map<Integer, Queen> awokenQueens;

    public PlayerState(){
      awokenQueens = new LinkedHashMap<>();
      cards = new LinkedHashMap<>();
    }

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }

    public Map<Integer, Queen> getAwokenQueens() {
        return awokenQueens;
    }

    public void setAwokenQueens(Map<Integer, Queen> awokenQueens) {
        this.awokenQueens = awokenQueens;
    }

    public void setCards(Map<Integer, Optional<Card>> cards) {
        this.cards = cards;
    }
}
