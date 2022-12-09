package Main;

import DataType.Position.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class GameAdaptorTest {

    private GameAdaptor gameAdaptor;

    private void setUp(){
        GameObservable gameObservable = new GameObservable();
        gameObservable.addPlayer("0",new GameObserverImplement());
        gameObservable.addPlayer("1",new GameObserverImplement());
        gameAdaptor = new GameAdaptor(gameObservable);
    }

    @Test
    public void play1() {
        setUp();
        List<Position> list = new ArrayList<>();
        String s = gameAdaptor.play("0","");

        assertEquals("", s);

    }


}