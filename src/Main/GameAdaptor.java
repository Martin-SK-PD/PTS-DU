package Main;

import DataType.Position.AwokenQueenPosition;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameAdaptor implements GamePlayerInterface{


    private Game game;
    private GameObservable gameObservable;
    private Map<String, Integer> players ;

    private GameAdaptor(){
        game = new Game();
        gameObservable = new GameObservable();
    }



    @Override
    public String play(String player, String cards) {

        int index;
        try {
            index = players.get(player);
        }
        catch (Exception e){
            return "player with name "+player+" don't exists";
        }
        List<Position> card = new ArrayList<>();

        Scanner scanner = new Scanner(cards);
        while (scanner.hasNext()){
            String s = scanner.next();
            char first = s.charAt(0);

            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 1; i < s.length(); i++){
                arrayList.add(Integer.parseInt( String.valueOf( s.charAt(i) ) ) );
            }

            try {
                switch (first) {
                    case 'h':
                        for (Integer integer : arrayList) {
                            card.add(new Position(new HandPosition(integer, index)));
                        }
                        break;
                    case 'a':
                        card.add(new Position(new AwokenQueenPosition(arrayList.get(1), arrayList.get(0))));
                        break;
                    case 's':
                        card.add(new Position(new SleepingQueenPosition(arrayList.get(0))));
                        break;
                }
            }
            catch (Exception e){
                return "something went wrong";
            }

        }


        return game.play(index,card).toString();
    }



}
