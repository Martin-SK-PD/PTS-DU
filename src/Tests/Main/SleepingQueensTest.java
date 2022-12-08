package Main;

import DataType.Position.SleepingQueenPosition;
import DataType.Queen;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class SleepingQueensTest {

    private SleepingQueens sleepingQueens;

    private void setUp(){
        sleepingQueens = new SleepingQueens();
    }

    @Test
    public void addQueen() {
        setUp();
        sleepingQueens.addQueen(new Queen(15));
        assertEquals(12, sleepingQueens.getQueens().size());

        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(0));
        Optional<Queen> queen1 = sleepingQueens.removeQueen(new SleepingQueenPosition(1));
        queen.ifPresent(value -> sleepingQueens.addQueen(value));
        assertEquals(11,sleepingQueens.getQueens().size());

        queen1.ifPresent(value -> sleepingQueens.addQueen(value));
        assertEquals(12,sleepingQueens.getQueens().size());
    }

    @Test
    public void removeQueen() {
        setUp();
        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(0));

        assertTrue(queen.isPresent());
        assertEquals(11, sleepingQueens.getQueens().size());

    }

    @Test
    public void getQueens() {
        setUp();
        assertEquals(12, sleepingQueens.getQueens().size());
    }
}