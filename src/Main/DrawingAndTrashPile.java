package Main;

import DataType.Card;
import EmptyDeck.EmptyDeckHandler;
import EmptyDeck.FirstType;


import java.util.ArrayList;
import java.util.List;

public class DrawingAndTrashPile {

    private List<Card> drawingPile;
    private List<Card> trashPile;
    private List<Card> discardedThisTurn;
    private EmptyDeckHandler emptyDeckHandler;



    public List<Card> discardAndDraw(List<Card> discard){

        List<Card> ret = new ArrayList<>();
        discardedThisTurn = discard;
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


}
