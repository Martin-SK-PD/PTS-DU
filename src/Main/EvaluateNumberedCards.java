package Main;

import DataType.Card;
import DataType.CardType;

import java.util.*;

public class EvaluateNumberedCards{

    public boolean play(List<Card> cards){



        //Key = Card.value , Value = count of cards
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (Card card : cards) {

            CardType type = card.getType();
            int value = card.getValue();

            if (type != CardType.Number) {
                return false;
            }

            try {
                int count = treeMap.get(value);
                treeMap.replace(value, count + 1);
            } catch (Exception e) {
                treeMap.put(value, 1);
            }
        }


        ArrayList<Integer> values = new ArrayList<>(treeMap.keySet());
        ArrayList<Integer> counts = new ArrayList<>(treeMap.values());


        if(values.isEmpty()){
            return false;
        }

        //Ak mame iba jednu hodnotu kariet tak vrátime true
        else if(values.size() == 1){
            return true;
        }

        //inak to musí byť rovnica
        else {

            int left_side = 0;
            int right_side;

            //ak mame viac kariet s max hodnotou tak vrátime false
            if(counts.get(counts.size()-1)  != 1) {
                return false;
            }

            //inak priradime pravu stranu
            else{
                right_side = values.get(values.size()-1);
            }

            //spočítame ľavú stranu
            for (int i = 0; i < values.size()-1; i++ ){
                left_side += values.get(i)*counts.get(i);
            }

            //vrátime true/false podla rovnosti strán
            return  left_side == right_side;

        }

    }
}
