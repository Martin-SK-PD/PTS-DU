package Main;

import DataType.Card;
import DataType.GameState;
import DataType.Position.AwokenQueenPosition;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;
import DataType.Queen;

import java.util.*;

public class Game {


    private GameState gameState;
    private DrawingAndTrashPile drawingAndTrashPile;
    private ArrayList<Player> players;
    private SleepingQueens sleepingQueens;
    private GameFinished gameFinished;


    public Game(int numberOfPlayers){

        gameState = new GameState();
        drawingAndTrashPile = new DrawingAndTrashPile();
        sleepingQueens = new SleepingQueens();
        gameFinished = new GameFinished();

        gameState.awokenQueens = new HashMap<>();
        gameState.numberOfPlayers = numberOfPlayers;
        gameState.onTurn = (int)(Math.random()*(gameState.numberOfPlayers-1) );
        gameState.cardsDiscartedLastTurn = new ArrayList<>();


        Set<SleepingQueenPosition> set = new HashSet<>();
        for(Position position : sleepingQueens.getQueens().keySet()){
            set.add((SleepingQueenPosition) position);
        }
        gameState.sleepingQueens = set;


        for (int i = 0; i < numberOfPlayers; i++){
            players.add(new Player(i,this));
        }




    }


    public Optional<GameState> play(int playerIdx, List<Position> cards){

        if(playerIdx != gameState.onTurn){
            return  Optional.empty();
        }

        if(players.get(playerIdx).play(cards)) {

            update();
            drawingAndTrashPile.newTurn();
            Optional<Integer> winner = gameFinished.isFinished();
            if (winner.isPresent()) {
                System.out.println("Winner: " + winner.get());
                gameState.onTurn = -1;
            }
            return Optional.of(gameState);
        }
        return Optional.empty();
    }

    public DrawingAndTrashPile getDrawingAndTrashPile() {
        return drawingAndTrashPile;
    }


    private void update(){


        gameState.onTurn =  (gameState.onTurn + 1) % gameState.numberOfPlayers;
        gameState.cardsDiscartedLastTurn = drawingAndTrashPile.getCardsDiscardedThisTurn();



        Set<SleepingQueenPosition> sleepingQueenPositions = new HashSet<>();
        for (Position position : sleepingQueens.getQueens().keySet()) {
            sleepingQueenPositions.add((SleepingQueenPosition) position);
        }
        gameState.sleepingQueens = sleepingQueenPositions;


        Map<AwokenQueenPosition, Queen> playersQueens = new HashMap<>();
        for(Player player : players){
            int i=0;
            for (Queen queen: player.getAwokenQueens().getQueens().values()){
                playersQueens.put(new AwokenQueenPosition(i,player.getPlayerId()),queen);
                i++;
            }
        }
        gameState.awokenQueens = playersQueens;


        Map<HandPosition, Optional<Card>> cards = new HashMap<>();
        for(Player player: players){
            int i = 0;
            for (Card card:player.getHand().getCards()){
                cards.put(new HandPosition(i,player.getPlayerId()),Optional.ofNullable(card));
                i++;
            }
        }
        gameState.cards = cards;

    }
}
