package Main;

import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.Map;
import java.util.Optional;

 abstract class QueenCollection {


    private Map<Position, Queen> queens;



    public void addQueen(Queen queen){

    }

    public Optional<Queen> removeQueen(SleepingQueenPosition position){
        return Optional.empty();
    }


    public Map<Position, Queen> getQueens(){
        return queens;
    }
}
