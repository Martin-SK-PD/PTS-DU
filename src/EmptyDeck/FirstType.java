package EmptyDeck;

import DataType.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstType implements EmptyDeckHandler{

    private List<Card> thisDrawingPile;
    private List<Card> thisTrashPile;

    public FirstType(){
        thisDrawingPile = new ArrayList<>();
        thisTrashPile = new ArrayList<>();
    }


    @Override
    public List<Card> play(List<Card> discard, List<Card> drawingPile, List<Card> trashPile) {


        trashPile.addAll(discard);

        List<Card> ret = new ArrayList<>(drawingPile);
        Collections.shuffle(trashPile);
        drawingPile = trashPile;
        trashPile = new ArrayList<>();

        while (ret.size() != discard.size()){
            ret.add(drawingPile.get(0));
            drawingPile.remove(0);
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
