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


    private final GameState gameState;
    private final DrawingAndTrashPile drawingAndTrashPile;
    private ArrayList<Player> players;
    private final SleepingQueens sleepingQueens;
    private final GameFinished gameFinished;


    public Game(int numberOfPlayers){

        gameState = new GameState();
        drawingAndTrashPile = new DrawingAndTrashPile();
        sleepingQueens = new SleepingQueens();
        players = new ArrayList<>();


        for (int i = 0; i < numberOfPlayers; i++){
            Hand hand = new Hand(drawingAndTrashPile,i);
            players.add(new Player(i, hand, sleepingQueens));
        }

        MoveQueen moveQueen = new MoveQueen(players,sleepingQueens);
        EvaluateAttack evaluateAttack = new EvaluateAttack(players,moveQueen);


        for (int i = 0; i< numberOfPlayers; i++){
            players.get(i).setEvaluateAttack(evaluateAttack);
            players.get(i).setMoveQueen(moveQueen);
        }

        gameState.numberOfPlayers = numberOfPlayers;
        gameState.onTurn = 0;
        gameState.cardsDiscartedLastTurn = new ArrayList<>();

        update();
        gameFinished = new GameFinished(this);
    }


    public Optional<GameState> play(int playerIdx, List<Position> cards){

        if(playerIdx != gameState.onTurn){
            return  Optional.empty();
        }

        if(players.get(playerIdx).play(cards)) {

            update();
            gameState.onTurn =  (gameState.onTurn + 1) % gameState.numberOfPlayers;
            gameState.cardsDiscartedLastTurn = drawingAndTrashPile.getCardsDiscardedThisTurn();

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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public SleepingQueens getSleepingQueens() {
        return sleepingQueens;
    }

    public GameState getGameState() {
        return gameState;
    }

    private void update(){

        Set<SleepingQueenPosition> sleepingQueenPositions = new LinkedHashSet<>();
        for (Position position : sleepingQueens.getQueens().keySet()) {
            sleepingQueenPositions.add((SleepingQueenPosition) position);
        }
        gameState.sleepingQueens = sleepingQueenPositions;


        Map<AwokenQueenPosition, Queen> playersQueens = new LinkedHashMap<>();
        for(Player player : players){
            int i=0;
            for (Queen queen: player.getAwokenQueens().getQueens().values()){
                playersQueens.put(new AwokenQueenPosition(i,player.getPlayerId()),queen);
                i++;
            }
        }
        gameState.awokenQueens = playersQueens;


        Map<HandPosition, Optional<Card>> cards = new LinkedHashMap<>();
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
