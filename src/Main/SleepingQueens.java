package Main;

import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.Map;
import java.util.Optional;

public class SleepingQueens extends QueenCollection{


    private Map<Position, Queen> sleepingQueens;


    @Override
    public void addQueen(Queen queen){

    }

    @Override
    public Optional<Queen> removeQueen(SleepingQueenPosition position){
        return Optional.empty();
    }


    @Override
    public Map<Position, Queen> getQueens(){
        return sleepingQueens;
    }
}
