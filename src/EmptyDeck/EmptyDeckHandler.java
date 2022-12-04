package EmptyDeck;

import DataType.Card;

import java.util.List;

public interface EmptyDeckHandler {

    List<Card> play(List<Card> discard, List<Card> drawingPile, List<Card> trashPile);
    List<Card> getDrawingPile();
    List<Card> getTrashPile();
}
