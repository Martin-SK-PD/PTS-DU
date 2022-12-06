package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.*;

public class AwokenQueens extends QueenCollection{


    private Map<Position, Queen> awokenQueens;
    private final int playerIdx;
    public List<Integer> emptySpaces;

    public AwokenQueens(int playerIdx){
        this.playerIdx = playerIdx;
        awokenQueens = new HashMap<>();
        emptySpaces = new ArrayList<>();
    }

    @Override
    public void addQueen(Queen queen){

        if(emptySpaces.isEmpty()){
            awokenQueens.put(new AwokenQueenPosition(awokenQueens.size(),playerIdx),queen);
        }
        else {
            awokenQueens.put(new AwokenQueenPosition(emptySpaces.get(0),playerIdx),queen);
            emptySpaces.remove(0);
        }
    }

    @Override
    public Optional<Queen> removeQueen(Position position){

        Optional<Queen> queen;
        queen = Optional.of(awokenQueens.remove(position));
        if(queen.isPresent()){
            emptySpaces.add(position.getCardIndex());
        }
        return queen;
    }


    @Override
    public Map<Position, Queen> getQueens(){
        return awokenQueens;
    }


}
