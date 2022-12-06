package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.Map;
import java.util.Optional;

 abstract class QueenCollection {


    abstract void addQueen(Queen queen);

    abstract Optional<Queen> removeQueen(Position position);

    abstract Map<Position, Queen> getQueens();

}
