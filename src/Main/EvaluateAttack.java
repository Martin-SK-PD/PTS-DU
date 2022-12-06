package Main;

import DataType.CardType;
import DataType.Position.HandPosition;
import DataType.Position.Position;

import java.util.ArrayList;
import java.util.List;

public class EvaluateAttack {

    private CardType defenseCardType;
    private Player player;
    private QueenCollection queenCollection;

    public EvaluateAttack(CardType defenseCardType, Player player, QueenCollection queenCollection){
        this.player = player;
        this.defenseCardType = defenseCardType;
        this.queenCollection = queenCollection;

    }

    public boolean play(Position targetQueen, int targetPlayerIdx){

        if( player.getGame().getPlayers().size() <= targetPlayerIdx ){
            return false;
        }
        if(!player.getGame().getPlayers().get(targetPlayerIdx).getAwokenQueens().getQueens().containsKey(targetQueen)){
            return false;
        }

        HandPosition defence = player.getGame().getPlayers().get(targetPlayerIdx).getHand().hasCardOfType(defenseCardType);

        if(defence == null){
            MoveQueen moveQueen = new MoveQueen(player, queenCollection);
            moveQueen.play(targetQueen);
        }
        else {
            List<HandPosition> list = new ArrayList<>();
            list.add(defence);
            player.getGame().getPlayers().get(targetPlayerIdx).getHand().pickCards(list);
            player.getGame().getPlayers().get(targetPlayerIdx).getHand().removePickedCardsAndRedraw();
        }

        return false;
    }

}
