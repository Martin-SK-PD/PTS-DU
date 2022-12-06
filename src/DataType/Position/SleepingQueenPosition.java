package DataType.Position;

public class SleepingQueenPosition implements  Position{


    private int cardIndex;


    public SleepingQueenPosition(int cardIndex){
        this.cardIndex = cardIndex;
    }

    @Override
    public int getCardIndex() {
        return cardIndex;
    }


}
