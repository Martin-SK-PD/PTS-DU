package Main;

import DataType.GameState;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    private void setUp(){
        game = new Game(2);
    }

    @Test
    public void play() {
        setUp();
        List<Position> list = new ArrayList<>();
        Optional<GameState> gameState = game.play(0,list);
        assertTrue(gameState.isEmpty());
    }

    @Test
    public void getDrawingAndTrashPile() {
        setUp();
        DrawingAndTrashPile drawingAndTrashPile = game.getDrawingAndTrashPile();
        assertNotNull(drawingAndTrashPile);
    }

    @Test
    public void getPlayers() {
        setUp();
        List<Player> players = game.getPlayers();
        assertEquals(2, players.size());
    }

    @Test
    public void getSleepingQueens() {
        setUp();

        assertNotNull(game.getSleepingQueens());
        assertEquals(12, game.getSleepingQueens().getQueens().size());
    }

    @Test
    public void getGameState() {
        setUp();
        GameState gameState = game.getGameState();

        assertNotNull(gameState);
        assertEquals(0, gameState.onTurn);

    }
}