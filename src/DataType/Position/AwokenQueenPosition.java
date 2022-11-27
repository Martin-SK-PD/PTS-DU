package DataType.Position;

public class AwokenQueenPosition{


    private int cardIndex;
    private int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex){
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;
    }


    public int getCardIndex() {
        return cardIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }
}
