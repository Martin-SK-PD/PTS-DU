import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;
import Main.Game;
import Main.GameFinished;

public class Trieda {

    public static void main(String[] args) {

        Game game = new Game(5);
        GameFinished gameFinished = new GameFinished(game);
        for(Position queen : game.getSleepingQueens().getQueens().keySet()){
            System.out.println(queen.getCardIndex());
        }

    }
}
