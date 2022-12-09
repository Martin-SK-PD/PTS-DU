package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class MoveQueenTest {

    private MoveQueen moveQueen;
    private SleepingQueens sleepingQueens;
    private List<Player> players;

    private void setUp(){
        players = new ArrayList<>();
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();
        sleepingQueens = new SleepingQueens();
        players.add(new Player(0,new Hand(drawingAndTrashPile,0),sleepingQueens)    );
        players.add(new Player(1,new Hand(drawingAndTrashPile,1), sleepingQueens)   );
        moveQueen = new MoveQueen(players, sleepingQueens);
    }


    @Test
    public void play1() {

        //moving sleeping queen to player awokenQueens
        setUp();
        moveQueen.setQueenCollection(players.get(0).getAwokenQueens());

        assertTrue(moveQueen.play(new SleepingQueenPosition(0)));

        assertEquals(1, players.get(0).getAwokenQueens().getQueens().size());
    }

    @Test
    public void play2() {
        setUp();

        //moving a non-existent queen to sleeping queens
        moveQueen.setQueenCollection(sleepingQueens);
        assertFalse(moveQueen.play(new AwokenQueenPosition(0,1)) );
    }

    @Test
    public void play3() {
        setUp();

        //moving player awoken queen back to sleepingQueens

        Optional<Queen> queen = sleepingQueens.removeQueen(new SleepingQueenPosition(0));
        queen.ifPresent(value -> players.get(0).getAwokenQueens().addQueen(value));

        moveQueen.setQueenCollection(sleepingQueens);
        moveQueen.play(new AwokenQueenPosition(0,0));
        assertEquals(0, players.get(0).getAwokenQueens().getQueens().size());
        assertEquals(12,sleepingQueens.getQueens().size());
    }



}