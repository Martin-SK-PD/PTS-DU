package DataType;

import java.util.Map;
import java.util.Optional;

public class PlayerState {

    private Map<Integer, Optional<Card>> cards;
    public Map<Integer, Queen> awokenQueens;

    public Map<Integer, Optional<Card>> getCards() {
        return cards;
    }


}
