package Main;

import DataType.Card;
import DataType.CardType;
import DataType.Position.HandPosition;

import java.util.*;

public class Hand {

    private DrawingAndTrashPile drawingAndTrashPile;
    private List<Card> cards;
    private List<Card> pickedCards;
    private final int playerId;


    public Hand(DrawingAndTrashPile drawingAndTrashPile, int playerId){
        this.playerId = playerId;
        this.drawingAndTrashPile = drawingAndTrashPile;
        cards = drawingAndTrashPile.draw5();
    }


    public Optional<List<Card>> pickCards(List<HandPosition> positions){

        if (positions.isEmpty()) return Optional.empty();
        for (HandPosition position : positions) {
            pickedCards.add(cards.get(position.getCardIndex()-1));
        }
        return Optional.ofNullable(pickedCards);

    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw(){

        cards.removeAll(pickedCards);


        Map<HandPosition, Card> ret = new HashMap<>();
        List<Card> drawnCards = drawingAndTrashPile.discardAndDraw(pickedCards);
        for (int i = 0; i < drawnCards.size(); i++) {
            ret.put(new HandPosition(i + cards.size() , playerId), drawnCards.get(i));
        }
        cards.addAll(drawnCards);

        returnPickedCards();
        return ret;
    }

    public void returnPickedCards(){
        pickedCards.clear();
    }

    public HandPosition hasCardOfType(CardType type){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getType() == type){
                return new HandPosition(i,playerId);
            }
        }
        return null;
    }

    public List<Card> getCards(){
        return cards;
    }

}
