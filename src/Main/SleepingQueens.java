package Main;

import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.*;

public class SleepingQueens extends QueenCollection{


    private Map<Position, Queen> sleepingQueens;

    public SleepingQueens(){
        sleepingQueens = new HashMap<>();


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
        sleepingQueens.put(new SleepingQueenPosition(sleepingQueens.size()),queen);
    }

    @Override
    public Optional<Queen> removeQueen(SleepingQueenPosition position){
        Optional<Queen> queen = Optional.empty();


        for (Position position1 :sleepingQueens.keySet()){
            if(position1.getCardIndex() == position.getCardIndex()){
                queen = Optional.of(sleepingQueens.get(position1));
                sleepingQueens.remove(position1,queen.get());
                break;
            }
        }
        return queen;
    }


    @Override
    public Map<Position, Queen> getQueens(){
        return sleepingQueens;
    }
}
