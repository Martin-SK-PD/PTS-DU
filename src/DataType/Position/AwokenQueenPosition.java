package DataType.Position;

public class AwokenQueenPosition implements Position{


    private int cardIndex;
    private int playerIndex;

    public AwokenQueenPosition(int cardIndex, int playerIndex){
        this.cardIndex = cardIndex;
        this.playerIndex = playerIndex;
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
