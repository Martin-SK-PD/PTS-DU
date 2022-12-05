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

    private GameAdaptor(GameObservable gameObservable){
        game = new Game();
        this.gameObservable = gameObservable;
        for(int i = 0; i < gameObservable.getPlayers().size(); i++){
            players.put(gameObservable.getPlayersName().get(0), gameObservable.getPlayers().get(1));
        }

    }



    @Override
    public String play(String player, String cards) {

        if(players.size() < 2 ){
            return "lack of players";
        }

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
                        card.add(new Position(new HandPosition(arrayList.get(0), index)));
                        break;
                    case 'a':
                        card.add(new Position(new AwokenQueenPosition(arrayList.get(1), arrayList.get(0))));
                        break;
                    case 's':
                        s = s.substring(1);
                        card.add(new Position(new SleepingQueenPosition(Integer.parseInt(s))));
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
