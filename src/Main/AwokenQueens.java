package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.Position;
import DataType.Queen;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AwokenQueens extends QueenCollection{


    private Map<Position, Queen> awokenQueens;
    private final int playerIdx;

    public AwokenQueens(int playerIdx){
        this.playerIdx = playerIdx;
        awokenQueens = new HashMap<>();
    }

    @Override
    public void addQueen(Queen queen){
        awokenQueens.put(new AwokenQueenPosition(awokenQueens.size(),playerIdx),queen);
    }

    @Override
    public Optional<Queen> removeQueen(Position position){

        Optional<Queen> queen;
        queen = Optional.of(awokenQueens.remove(position));

        return queen;
    }


    @Override
    public Map<Position, Queen> getQueens(){
        return awokenQueens;
    }


}
