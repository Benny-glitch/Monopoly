package it.monopoly.app;

import java.util.Random;

public class Dice {
    private final int max_bound  = 6;
    private final int min_bound = 1;
    private int roll1;
    private int roll2;
    private Random random;
    public Dice(){
        random = new Random();
    }

    public int roll(){
        roll1 = random.nextInt(max_bound - min_bound) + min_bound;
        roll2 = random.nextInt(max_bound - min_bound) + min_bound;

        return roll1 + roll2;
    }

    public int currentRoll(){
            return roll1 + roll2;
        }

    public boolean isDouble(){
            return roll1 == roll2;
        }
}
