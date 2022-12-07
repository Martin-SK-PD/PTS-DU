package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class GameFinishedTest {

    private GameFinished gameFinished;
    public Game game;

    private void setUp(int i){
        game = new Game(i);
        gameFinished = new GameFinished(game);
    }



    @Test
    public void isFinished1() {
        setUp(2);
        assertTrue(gameFinished.isFinished().isEmpty());
    }


    @Test
    public void isFinished2() {
        setUp(4);
        game.getSleepingQueens().getQueens().clear();
        assertTrue(gameFinished.isFinished().isPresent());
    }

    @Test
    public void isFinished3() {
        setUp(5);

        for (int i = 0; i < 4; i++){
            Optional <Queen> queen = game.getSleepingQueens().removeQueen(new SleepingQueenPosition(i));
            if(queen.isPresent()){
                game.getPlayers().get(1).getAwokenQueens().addQueen(queen.get());
            }

        }

        assertTrue(gameFinished.isFinished().isPresent());
    }

}