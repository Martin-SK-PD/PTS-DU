package Main;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameObservableTest {


    private GameObservable gameObservable;

    private void setUp(){
        gameObservable = new GameObservable();
    }

    @Test
    public void add() {
        setUp();
        gameObservable.add(new GameObserverImplement());

    }

    @Test
    public void addPlayer() {
        setUp();
        gameObservable.addPlayer("1",new GameObserverImplement());
        gameObservable.addPlayer("1",new GameObserverImplement());

        assertEquals(1, gameObservable.getPlayersName().size());

    }

    @Test
    public void remove() {
        setUp();
        GameObserverImplement gameObserverImplement = new GameObserverImplement();
        gameObservable.add(gameObserverImplement);
        gameObservable.remove(gameObserverImplement);

        assertEquals(0,gameObservable.getGameObservers().size());

    }

}