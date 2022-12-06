package DataType.Position;

public class HandPosition implements Position {

    private int cardIndex;
    private int playerIndex;

    public HandPosition(int cardIndex, int playerIndex){
        this.playerIndex = playerIndex;
        this.cardIndex = cardIndex;
    }

    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int index){
        cardIndex = index;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
