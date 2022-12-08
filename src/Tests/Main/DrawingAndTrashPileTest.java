package Main;

import DataType.Card;
import DataType.CardType;
import EmptyDeck.EmptyDeckHandler;
import EmptyDeck.FirstType;
import EmptyDeck.Secondtype;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DrawingAndTrashPileTest {

    private DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();
    public List<Card> discard = new ArrayList<>();


    private void setUp(){
        drawingAndTrashPile = new DrawingAndTrashPile();
        discard.add(new Card(CardType.Number,5));
        discard.add(new Card(CardType.Number,7));
        discard.add(new Card(CardType.Number,2));
    }


    @Test
    public void discardAndDraw() {
        setUp();
        List<Card> newCards = drawingAndTrashPile.discardAndDraw(discard);
        assertEquals(3, newCards.size());
    }


    @Test
    public void getCardsDiscardedThisTurn() {
        setUp();
        drawingAndTrashPile.discardAndDraw(discard);
        assertEquals(3, drawingAndTrashPile.getCardsDiscardedThisTurn().size());
        for (Card card: discard){
            assertTrue(drawingAndTrashPile.getCardsDiscardedThisTurn().contains(card));
        }

    }


    @Test
    public void newTurn() {
        drawingAndTrashPile.newTurn();
        assertTrue(drawingAndTrashPile.getCardsDiscardedThisTurn().isEmpty());
    }


    @Test
    public void setEmptyDeckHandler() {
        EmptyDeckHandler emptyDeckHandler = new FirstType();
        drawingAndTrashPile.setEmptyDeckHandler(emptyDeckHandler);
        assertTrue(drawingAndTrashPile.getEmptyDeckHandler() instanceof FirstType);

        emptyDeckHandler = new Secondtype();
        drawingAndTrashPile.setEmptyDeckHandler(emptyDeckHandler);
        assertTrue(drawingAndTrashPile.getEmptyDeckHandler() instanceof Secondtype);
    }

    @Test
    public void draw5() {
        List<Card> list = new ArrayList<>(drawingAndTrashPile.draw5());
        assertEquals(5,list.size());
    }
}