package SnakeAndLadder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int diceCount;
    private final int min = 1, max = 6;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }

    public int roll(){
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount){
            totalSum += ThreadLocalRandom.current().nextInt(min, max+1);
            diceUsed++;
        }

        return totalSum;
    }
}
