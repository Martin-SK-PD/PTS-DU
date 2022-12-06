package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.Optional;

public class MoveQueen {

    private Player player;
    private QueenCollection queenCollection;

    public MoveQueen(Player player, QueenCollection queenCollection){
        this.player = player;
        this.queenCollection = queenCollection;
    }

    boolean play(Position targetQueen){

        if(targetQueen instanceof AwokenQueenPosition){

            int target = ((AwokenQueenPosition) targetQueen).getPlayerIndex();
            Optional<Queen> queen = player.getGame().getPlayers().get(target).getAwokenQueens().removeQueen(targetQueen);
            if(queen.isPresent()){
                queenCollection.addQueen(queen.get());
            }
            return false;
        }
        else if(targetQueen instanceof SleepingQueenPosition) {
            Optional<Queen> queen = player.getGame().getSleepingQueens().removeQueen(targetQueen);
            if (queen.isPresent()) {
                queenCollection.addQueen(queen.get());
                return true;
            }
            return false;
        }
        return false;
    }
}
