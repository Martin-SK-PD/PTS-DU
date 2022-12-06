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
    public Optional<Queen> removeQueen(Position position){
        Optional<Queen> queen;
        queen = Optional.of(sleepingQueens.remove(position));
        return queen;
    }


    @Override
    public Map<Position, Queen> getQueens(){
        return sleepingQueens;
    }
}
