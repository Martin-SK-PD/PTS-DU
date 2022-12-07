package Main;

import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.*;

public class SleepingQueens extends QueenCollection{


    private Map<Position, Queen> sleepingQueens;
    private List<Integer> emptySpaces;

    public SleepingQueens(){
        sleepingQueens = new LinkedHashMap<>();
        emptySpaces = new ArrayList<>();

        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < 4; i++ ) {
            points.add(5);
        }
        for (int i = 0; i < 4; i++ ) {
            points.add(10);
        }
        for (int i = 0; i < 3; i++ ) {
            points.add(15);
        }
        points.add(20);

        Collections.shuffle(points);

        for (int i = 0; i < 12; i++) {
            addQueen(new Queen(points.get(i)));
        }



    }

    @Override
    public void addQueen(Queen queen){
        if(emptySpaces.isEmpty()){
            sleepingQueens.put(new SleepingQueenPosition(sleepingQueens.size()),queen);
        }
        else {
            sleepingQueens.put(new SleepingQueenPosition(emptySpaces.get(0) ),queen );
            emptySpaces.remove(0);
        }

    }


    @Override
    public Optional<Queen> removeQueen(Position position){

        Optional<Queen> queen = Optional.empty();
        for (Position position1 : sleepingQueens.keySet()){
            if(position.getCardIndex() == position1.getCardIndex()){
                queen = Optional.ofNullable(sleepingQueens.remove(position1));
                break;
            }
        }
        if(queen.isPresent()){
            emptySpaces.add(position.getCardIndex());
        }
        return queen;
   }


    @Override
    public Map<Position, Queen> getQueens(){
        return sleepingQueens;
    }
}
