package Main;

import DataType.*;
import DataType.Position.AwokenQueenPosition;
import DataType.Position.HandPosition;
import DataType.Position.Position;
import DataType.Position.SleepingQueenPosition;

import java.util.*;

public class Player {

    private final int playerId;
    private PlayerState playerState;
    private Hand hand;

    private AwokenQueens awokenQueens;
    private SleepingQueens sleepingQueens;

    private EvaluateAttack evaluateAttack;
    private MoveQueen moveQueen;

    public Player(int playerId, Hand hand, SleepingQueens sleepingQueens){
        this.playerId = playerId;
        this.hand = hand;
        this.sleepingQueens = sleepingQueens;


        playerState = new PlayerState();
        awokenQueens = new AwokenQueens(playerId);

        playerState = new PlayerState();
        uptadePlayerState();

    }

    public void setEvaluateAttack(EvaluateAttack evaluateAttack) {
        this.evaluateAttack = evaluateAttack;
    }

    public void setMoveQueen(MoveQueen moveQueen) {
        this.moveQueen = moveQueen;
    }




    public boolean play(List<Position> cards){


        if (cards.isEmpty()) {
            return false;
        }



        if (!(cards.get(0) instanceof HandPosition)) {
            //first card has to be in hand
            return false;
        }
        if(((HandPosition) cards.get(0)).getPlayerIndex()!= playerId){
            //it must be players on turn card
            return false;
        }

        List<HandPosition> listOfHandPos = new ArrayList<>();


        //if size is == 1, it has to be numberCard
        if (cards.size() == 1) {

            listOfHandPos.add((HandPosition) cards.get(0));
        }
        else
        if (cards.size() == 2) {

            Card firstCard = hand.getCards().get(cards.get(0).getCardIndex());


            switch (firstCard.getType()) {
                case King -> {
                    Position targetQueen = cards.get(1);
                    if (targetQueen instanceof SleepingQueenPosition) {

                        moveQueen.setQueenCollection(awokenQueens);
                        if (!moveQueen.play(targetQueen)) {
                            return false;
                        }
                        listOfHandPos.add((HandPosition) cards.get(0));
                    } else {
                        return false;
                    }
                }
                case Knight -> {
                    Position targetQueen1 = cards.get(1);
                    if (targetQueen1 instanceof AwokenQueenPosition) {

                        evaluateAttack.setDefenseCardType(CardType.Dragon);
                        evaluateAttack.setQueenCollection(awokenQueens);
                        if (!evaluateAttack.play(targetQueen1, ((AwokenQueenPosition) targetQueen1).getPlayerIndex())) {
                            return false;
                        }
                        listOfHandPos.add((HandPosition) cards.get(0));
                    } else {
                        return false;
                    }
                }
                case SleepingPotion -> {
                    Position targetQueen2 = cards.get(1);
                    if (targetQueen2 instanceof AwokenQueenPosition) {

                        evaluateAttack.setDefenseCardType(CardType.MagicWand);
                        evaluateAttack.setQueenCollection(sleepingQueens);

                        if (!evaluateAttack.play(targetQueen2, ((AwokenQueenPosition) targetQueen2).getPlayerIndex())) {
                            return false;
                        }
                        listOfHandPos.add((HandPosition) cards.get(0));
                    } else {
                        return false;
                    }
                }
                default -> {
                    if (!(cards.get(1) instanceof HandPosition)) {
                        //wrong type of card
                        return false;
                    }

                    Optional<Card> secondCard = playerState.getCards().get(cards.get(1).getCardIndex());
                    if (secondCard.isEmpty()) {
                        return false;
                    }
                    if (firstCard.getType() != CardType.Number || secondCard.get().getType() != CardType.Number) {
                        //wrong card
                        return false;
                    } else {
                        EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
                        List<Card> list = new ArrayList<>();
                        list.add(firstCard);
                        list.add(secondCard.get());
                        if (!evaluateNumberedCards.play(list)) {
                            return false;
                        }
                        listOfHandPos.add((HandPosition) cards.get(0));
                        listOfHandPos.add((HandPosition) cards.get(1));
                    }
                }
            }
        }
        else {
            ArrayList<Card> numberCards = new ArrayList<>();
            ArrayList<Integer> cardPositions = new ArrayList<>();


            for (Position position : cards) {

                if (!(position instanceof HandPosition)) {
                    //wrong types of cards
                    return false;
                }


                Optional<Card> card = playerState.getCards().get(cards.get(0).getCardIndex());
                if (card.isEmpty()) {
                    return false;
                }

                if(!cardPositions.contains(position.getCardIndex())) {
                    cardPositions.add(position.getCardIndex());

                    if(card.get().getType() != CardType.Number){
                        return false;
                    }
                    numberCards.add(card.get());
                    listOfHandPos.add((HandPosition) position);
                }
            }

            EvaluateNumberedCards evaluateNumberedCards = new EvaluateNumberedCards();
            if (!evaluateNumberedCards.play(numberCards)) {
                return false;
            }
        }


        hand.pickCards(listOfHandPos);
        hand.removePickedCardsAndRedraw();
        uptadePlayerState();
        return true;
    }

    public PlayerState getPlayerState(){
        return playerState;
    }

    private void uptadePlayerState(){


        playerState = new PlayerState();

        Map<Integer, Optional<Card>> cards = new LinkedHashMap<>();

        List<Card> handCards = hand.getCards();
        for (int i = 0; i < 5; i++) {
                cards.put(i, Optional.of(handCards.get(i)));
                cards.put(i, Optional.empty());
        }
        playerState.setCards(cards);

        Map<Integer, Queen> queens = new LinkedHashMap<>();
        for(Position position: awokenQueens.getQueens().keySet()){
            queens.put(position.getCardIndex(), awokenQueens.getQueens().get(position));
        }

        playerState.awokenQueens = queens;
    }


    public int getPlayerId() {
        return playerId;
    }

    public AwokenQueens getAwokenQueens() {
        return awokenQueens;
    }

    public Hand getHand() {
        return hand;
    }
}
