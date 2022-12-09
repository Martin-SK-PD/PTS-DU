package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Queen;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class AwokenQueensTest {

    private AwokenQueens awokenQueens;

    private void setUp(){
        awokenQueens = new AwokenQueens(0);
    }


    @Test
    public void addQueen() {
        setUp();
        awokenQueens.addQueen(new Queen(10));
        assertEquals(1, awokenQueens.getQueens().size());
    }

    @Test
    public void removeQueen() {
        setUp();
        assertFalse(awokenQueens.removeQueen(new AwokenQueenPosition(0,0)).isPresent());

        awokenQueens.addQueen(new Queen(5));
        awokenQueens.addQueen(new Queen(10));

        Optional<Queen> queen = awokenQueens.removeQueen(new AwokenQueenPosition(1,0));
        queen.ifPresent(value -> assertEquals(10, value.getPoints()));
    }

    @Test
    public void getQueens() {
        setUp();
        assertTrue(awokenQueens.getQueens().isEmpty());
    }
}