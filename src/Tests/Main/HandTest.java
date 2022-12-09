package Main;

import DataType.Card;
import DataType.CardType;
import DataType.Position.HandPosition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class HandTest {


    private Hand hand;

    private void setUp(){
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();
        hand = new Hand(drawingAndTrashPile,1);
    }

    private List<HandPosition> getHandPosList(){
        List<HandPosition> positions = new ArrayList<>();
        positions.add(new HandPosition(0,1));
        positions.add(new HandPosition(1,1));
        positions.add(new HandPosition(2,1));

        return positions;
    }

    @Test
    public void pickCards() {
        setUp();
        List<HandPosition> positions = getHandPosList();

        Optional<List<Card>> cards = hand.pickCards(positions);

        cards.ifPresent(cardList -> assertEquals(3, cardList.size()));

    }

    @Test
    public void removePickedCardsAndRedraw() {
        setUp();
        List<HandPosition> positions = getHandPosList();
        hand.pickCards(positions);

        Map<HandPosition,Card > map = hand.removePickedCardsAndRedraw();

        assertEquals(3, map.size());

        int i = 5 - positions.size();
        for(HandPosition position : map.keySet()){

            assertEquals(position.getCardIndex(), i);
            i++;
        }

    }


    @Test
    public void hasCardOfType() {

        setUp();

        HandPosition handPosition = hand.hasCardOfType(CardType.Number);

        if(handPosition != null) {
            assertEquals(1, handPosition.getPlayerIndex());
            int i = handPosition.getCardIndex();
            assertTrue(i >= 0 && i <= 4);
        }

    }

    @Test
    public void getCards() {
        setUp();
        assertEquals(5, hand.getCards().size());
    }
}