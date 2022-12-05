package Main;

import DataType.Card;
import DataType.CardType;
import DataType.GameState;
import DataType.Position.HandPosition;

import java.util.*;

public class Hand {

    private final int playerIndex;
    private DrawingAndTrashPile drawingAndTrashPile;
    private GameState gameState;
    private List<Card> cards;


    public Hand(int playerIndex, DrawingAndTrashPile drawingAndTrashPile, GameState gameState){
        this.playerIndex = playerIndex;
        this.drawingAndTrashPile = drawingAndTrashPile;
        this.gameState = gameState;
    }


    public Optional<List<Card>> pickCards(List<HandPosition> positions){

        cards = new ArrayList<>();
        for (HandPosition position : positions) {
            Optional<Card> card = gameState.cards.get(position);
            if(card.isPresent()) {
                cards.add(card.get());
            }
        }
        return Optional.ofNullable(cards);
    }

    public Map<HandPosition, Card> removePickedCardsAndRedraw(){
        List<Card> cards1 = drawingAndTrashPile.discardAndDraw(cards);

        Map<HandPosition, Card> map = new HashMap<>();

        return map;
    }

    public void returnPickedCards(){
        
    }

    public HandPosition hasCardOfType(CardType type){


        return null;
    }

    public List<Card> getCards(){

        return cards;
    }

}
