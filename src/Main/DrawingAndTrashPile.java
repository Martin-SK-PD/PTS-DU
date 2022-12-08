package Main;

import DataType.Card;
import DataType.CardType;
import EmptyDeck.EmptyDeckHandler;
import EmptyDeck.FirstType;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawingAndTrashPile {

    private List<Card> drawingPile;
    private List<Card> trashPile;
    private List<Card> discardedThisTurn;
    private EmptyDeckHandler emptyDeckHandler;

    public DrawingAndTrashPile(){
        discardedThisTurn = new ArrayList<>();
        trashPile = new ArrayList<>();
        drawingPile = new ArrayList<>();


        for (int i = 0; i < 8; i++){
            drawingPile.add(new Card(CardType.King,0));
        }

        for (int i = 0; i < 4; i++){
            drawingPile.add(new Card(CardType.Knight,0));
        }

        for (int i = 0; i < 4; i++){
            drawingPile.add(new Card(CardType.SleepingPotion,0));
        }

        for (int i = 0; i < 3; i++){
            drawingPile.add(new Card(CardType.MagicWand,0));
        }

        for (int i = 0; i < 3; i++){
            drawingPile.add(new Card(CardType.Dragon,0));
        }

        for(int i = 0; i < 4 ; i++){
            for (int j = 1; j <= 10; j++){
                drawingPile.add(new Card(CardType.Number,j));
            }
        }

        Collections.shuffle(drawingPile);


    }

    public List<Card> discardAndDraw(List<Card> discard){

        List<Card> ret = new ArrayList<>();
        discardedThisTurn.addAll(discard);
        int count = discard.size();


        if(count <= drawingPile.size()){

            for(int i = 0; i <count; i++) {
                ret.add(drawingPile.get(0));
                drawingPile.remove(0);
            }
            trashPile.addAll(discardedThisTurn);
        }
        else {

            if(emptyDeckHandler == null){
                emptyDeckHandler = new FirstType();
            }

            ret = emptyDeckHandler.play(discard, drawingPile, trashPile);
            drawingPile = emptyDeckHandler.getDrawingPile();
            trashPile = emptyDeckHandler.getTrashPile();
        }
        return ret;
    }

    public void newTurn(){
        discardedThisTurn.clear();
    }

    public List<Card> getCardsDiscardedThisTurn(){
        return discardedThisTurn;
    }

    public void setEmptyDeckHandler(EmptyDeckHandler e){
        emptyDeckHandler = e;
    }


    public List<Card> draw5(){
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cards.add(drawingPile.get(0));
            drawingPile.remove(0);
        }
        return cards;
    }


    //for testing
    public EmptyDeckHandler getEmptyDeckHandler() {
        return emptyDeckHandler;
    }
}
