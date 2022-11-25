package Main;

public class SleepingQueenPosition extends Position{


    int cardIndex;

    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public int getPlayerIndex() {
        return -1;
    }
}
