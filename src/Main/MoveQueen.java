package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.List;
import java.util.Optional;

public class MoveQueen {

    private List<Player> players;
    private QueenCollection queenCollection;

    public MoveQueen(List<Player> players){
        this.players = players;
    }

    public void setQueenCollection(QueenCollection queenCollection) {
        this.queenCollection = queenCollection;
    }

    boolean play(Position targetQueen){

        if(targetQueen instanceof AwokenQueenPosition){

            int target = ((AwokenQueenPosition) targetQueen).getPlayerIndex();

            Optional<Queen> queen = players.get(target).getAwokenQueens().removeQueen(targetQueen);
            if(queen.isPresent()){
                queenCollection.addQueen(queen.get());
            }
            return false;
        }
        else if(targetQueen instanceof SleepingQueenPosition) {

            Optional<Queen> queen = queenCollection.removeQueen(targetQueen);
            if (queen.isPresent()) {
                queenCollection.addQueen(queen.get());
                return true;
            }
            return false;
        }
        return false;
    }
}
