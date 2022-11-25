package Main;

public class HandPosition extends Position{

    int cardIndex;
    int playerIndex;


    @Override
    public int getCardIndex() {
        return cardIndex;
    }

    @Override
    public int getPlayerIndex() {
        return playerIndex;
    }
}
