package Main;

import DataType.CardType;
import DataType.Position.HandPosition;
import DataType.Position.Position;

import java.util.ArrayList;
import java.util.List;

public class EvaluateAttack {

    private CardType defenseCardType;
    private QueenCollection queenCollection;
    private List<Player> players;
    private MoveQueen moveQueen;
    private int playerOnTurn;

    public EvaluateAttack( List<Player> players, MoveQueen moveQueen){
        this.players = players;
        this.moveQueen = moveQueen;
    }

    public void setQueenCollection(QueenCollection queenCollection) {
        this.queenCollection = queenCollection;
    }

    public void setPlayerOnTurn(int playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }

    public void setDefenseCardType(CardType defenseCardType) {
        this.defenseCardType = defenseCardType;
    }

    public boolean play(Position targetQueen, int targetPlayerIdx){

        if( players.size() <= targetPlayerIdx ){
            return false;
        }
        if(!players.get(targetPlayerIdx).getAwokenQueens().getQueens().containsKey(targetQueen)){
            return false;
        }

        HandPosition defence = players.get(targetPlayerIdx).getHand().hasCardOfType(defenseCardType);

        if(defence == null){
            moveQueen.setQueenCollection(queenCollection);
            moveQueen.setPlayerOnTurn(playerOnTurn);
            moveQueen.play(targetQueen);
        }
        else {
            List<HandPosition> list = new ArrayList<>();
            list.add(defence);
            players.get(targetPlayerIdx).getHand().pickCards(list);
            players.get(targetPlayerIdx).getHand().removePickedCardsAndRedraw();
        }

        return false;
    }

}
