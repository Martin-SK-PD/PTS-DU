package Main;

import DataType.GameState;
import DataType.Queen;

import java.util.*;

public class GameFinished implements GameFinishedStrategy{

    private Game game;
    private final int score ;
    private final int queenCount;

    public GameFinished(Game game) {
        this.game = game;
        if (game.getPlayers().size() == 2 || game.getPlayers().size() == 3) {
            score = 50;
            queenCount = 5;

        } else if (game.getPlayers().size() == 4 || game.getPlayers().size() == 5) {
            score = 40;
            queenCount = 4;
        }
        else {
            score = 1000;
            queenCount = 20;
        }
    }

    @Override
    public Optional<Integer> isFinished() {

        Map<Integer,Integer> playersScores = new LinkedHashMap<>();



        for (Player player: game.getPlayers()){
            int id = player.getPlayerId();
            int c = 0;
            int s = 0;
            for(Queen queen : player.getAwokenQueens().getQueens().values()){
                s+= queen.getPoints();
                c++;
            }
            playersScores.put(id,s);
            if(c >= queenCount || s >= score){
                return Optional.of(id);
            }
        }

        if(game.getSleepingQueens().getQueens().size() == 0){

            int winner = -1;
            int winCount = -1;
            List<Integer> playersId = new ArrayList<>(playersScores.keySet());

            for(Integer i : playersId){
                if (winCount < playersScores.get(i)){
                    winner = i;
                    winCount = playersScores.get(i);
                }
            }

            return Optional.of(winner);

        }


        return Optional.empty();
    }



}
