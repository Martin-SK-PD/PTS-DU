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

    public EvaluateAttack( List<Player> players, MoveQueen moveQueen ){
        this.players = players;
        this.moveQueen = moveQueen;
    }

    public void setQueenCollection(QueenCollection queenCollection) {
        this.queenCollection = queenCollection;
    }



    public void setDefenseCardType(CardType defenseCardType) {
        this.defenseCardType = defenseCardType;
    }

    public boolean play(Position targetQueen, int targetPlayerIdx){

        if( players.size() <= targetPlayerIdx ){
            return false;
        }

        boolean containsTargetQueenPosition = false;
        for(Position position : players.get(targetPlayerIdx).getAwokenQueens().getQueens().keySet()){
            if(position.getCardIndex() == targetQueen.getCardIndex()){
                containsTargetQueenPosition = true;
                break;
            }
        }

        if(!containsTargetQueenPosition){
            return false;
        }

        HandPosition defence = players.get(targetPlayerIdx).getHand().hasCardOfType(defenseCardType);

        if(defence == null){
            moveQueen.setQueenCollection(queenCollection);
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
