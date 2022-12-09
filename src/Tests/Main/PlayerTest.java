package Main;

import DataType.CardType;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Hand hand;

    private void setUp(){
        DrawingAndTrashPile drawingAndTrashPile = new DrawingAndTrashPile();
        hand = new Hand(drawingAndTrashPile,0);
        SleepingQueens sleepingQueens = new SleepingQueens();
        player = new Player(0,hand, sleepingQueens);
        List<Player> players = new ArrayList<>();
        players.add(player);
        player.setMoveQueen(new MoveQueen(players,sleepingQueens) );
    }

    @Test
    public void play1() {
        setUp();
        HandPosition handPosition = hand.hasCardOfType(CardType.Number);
        if( handPosition != null){
            List<Position> list = new ArrayList<>();
            list.add(handPosition);
            assertTrue(player.play(list) );
        }

    }

    @Test
    public void play2() {
        setUp();
        HandPosition handPosition = hand.hasCardOfType(CardType.King);
        if( handPosition != null){
            List<Position> list = new ArrayList<>();
            list.add(handPosition);
            list.add(new SleepingQueenPosition(0));
            assertTrue(player.play(list) );
            assertEquals(1, player.getAwokenQueens().getQueens().size());
        }

    }

    @Test
    public void getPlayerState() {
        setUp();
        assertNotNull( player.getPlayerState() ) ;
    }


}