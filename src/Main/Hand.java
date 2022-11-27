package Main;

import DataType.Card;
import DataType.CardType;
import DataType.Position.HandPosition;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Hand {

    private int playerIndex;

    public Optional<List<Card>> pickCards(List<HandPosition> positions){


        return  Optional.empty();
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw(){

        return null;
    }

    public void returnPickedCards(){

    }

    public HandPosition hasCardOfType(CardType type){

        return null;
    }

    public List<Card> getCards(){

        return null;
    }

}
