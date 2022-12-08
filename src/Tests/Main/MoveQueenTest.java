package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.SleepingQueenPosition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoveQueenTest {

    private MoveQueen moveQueen;
    private List<Player> players;

    private void setUp(){
        players = new ArrayList<>();
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();

        players.add(new Player(0,new Hand(drawingAndTrashPile,0)));
        players.add(new Player(1,new Hand(drawingAndTrashPile,1)));
        moveQueen = new MoveQueen(players);
    }


    @Test
    public void play1() {
        setUp();
        moveQueen.setQueenCollection(new SleepingQueens());
        moveQueen.setPlayerOnTurn(0);
        assertTrue(moveQueen.play(new SleepingQueenPosition(0)));

        assertEquals(1, players.get(0).getAwokenQueens().getQueens().size());
    }

    @Test
    public void play2() {
        setUp();
        moveQueen.setQueenCollection(players.get(0).getAwokenQueens());
        assertFalse(moveQueen.play(new AwokenQueenPosition(0,1)) );
    }
}