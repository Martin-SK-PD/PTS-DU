package Main;

import DataType.Card;
import DataType.CardType;
import DataType.Position.HandPosition;

import java.util.*;

public class Hand {

    private Player player;
    private List<Card> cards;
    private List<Card> pickedCards;


    public Hand(Player player){
        this.player = player;
        cards = player.getGame().getDrawingAndTrashPile().draw5();
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
        List<Card> drawnCards = player.getGame().getDrawingAndTrashPile().discardAndDraw(pickedCards);
        for (int i = 0; i < drawnCards.size(); i++) {
            ret.put(new HandPosition(i + cards.size() , player.getPlayerId()), drawnCards.get(i));
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
                return new HandPosition(i,player.getPlayerId());
            }
        }
        return null;
    }

    public List<Card> getCards(){
        return cards;
    }

}
