package DataType.Position;

public class HandPosition {

    private int cardIndex;
    private int playerIndex;

    public HandPosition(int cardIndex, int playerIndex){
        this.playerIndex = playerIndex;
        this.cardIndex = cardIndex;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
