package EmptyDeck;

import DataType.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Secondtype implements  EmptyDeckHandler{

    private List<Card> thisDrawingPile;
    private List<Card> thisTrashPile;

    public Secondtype(){
        thisDrawingPile = new ArrayList<>();
        thisTrashPile = new ArrayList<>();
    }

    @Override
    public List<Card> play(List<Card> discard, List<Card> drawingPile, List<Card> trashPile) {

        Collections.shuffle(trashPile);
        drawingPile.addAll(trashPile);
        trashPile = new ArrayList<>(discard);

        List<Card> ret = new ArrayList<>();
        for(int i = 0; i < discard.size();i++){
            ret.add(drawingPile.get(i));
            drawingPile.remove(i);
        }

        thisDrawingPile = drawingPile;
        thisTrashPile = trashPile;

        return ret;
    }

    @Override
    public List<Card> getDrawingPile() {
        return thisDrawingPile;
    }

    @Override
    public List<Card> getTrashPile() {
        return thisTrashPile;
    }
}
