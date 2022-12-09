package Main;

public class GameObserverImplement implements GameObserver{

    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
