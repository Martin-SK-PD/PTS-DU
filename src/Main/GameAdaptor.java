package Main;

import DataType.GameState;
import DataType.Position.AwokenQueenPosition;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;

import java.util.*;

public class GameAdaptor implements GamePlayerInterface{


    private Game game;
    private GameObservable gameObservable;
    private Map<String, Integer> players ;

    public GameAdaptor(GameObservable gameObservable){

        this.gameObservable = gameObservable;
        players = new LinkedHashMap<>();
        for(int i = 0; i < gameObservable.getPlayersName().size(); i++){
            players.put( gameObservable.getPlayersName().get(i) , i);
        }
        game = new Game(players.size());
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
                        card.add(new HandPosition(arrayList.get(0), index));
                        break;
                    case 'a':
                        card.add(new AwokenQueenPosition(arrayList.get(1), arrayList.get(0)));
                        break;
                    case 's':
                        s = s.substring(1);
                        card.add(new SleepingQueenPosition(Integer.parseInt(s)));
                        break;
                }
            }
            catch (Exception e){
                return "something went wrong";
            }

        }

        Optional<GameState> gameState = game.play(index,card);

        if(gameState.isPresent()){
            gameObservable.notifyAll(gameState.get());
            return gameState.get().toString();
        }

        return "";
    }

}
