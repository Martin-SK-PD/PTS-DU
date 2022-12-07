package Main;

import DataType.Card;
import DataType.CardType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EvaluateNumberedCardsTest {

    private EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
    private List<Card> list;

    private void setUp(){
        list = new ArrayList<>();
    }

    @Test
    public void playTest1() {
        setUp();
        list.add(new Card(CardType.Number,4));
        assertTrue(evaluateNumberedCards.play(list));
    }


    @Test
    public void playTest2() {
        setUp();
        list.add(new Card(CardType.Number,10));
        list.add(new Card(CardType.Number,10));
        assertTrue(evaluateNumberedCards.play(list));
    }


    @Test
    public void playTest3() {
        setUp();
        list.add(new Card(CardType.Number,4));
        list.add(new Card(CardType.Number,5));
        list.add(new Card(CardType.Number,5));
        assertFalse(evaluateNumberedCards.play(list));
    }


    @Test
    public void playTest4() {
        setUp();
        list.add(new Card(CardType.Number,4));
        list.add(new Card(CardType.Number,7));
        list.add(new Card(CardType.Number,3));
        assertTrue(evaluateNumberedCards.play(list));
    }


}