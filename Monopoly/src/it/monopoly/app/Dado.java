package it.monopoly.app;

public class Dado {
    private int roll1;
    private int roll2;

    public Dado(){}

    public int roll(){
        roll1 = (int) (Math.random() * 6 + 1);
        roll2 = (int) (Math.random() * 6 + 1);

        return roll1 + roll2;
    }

    public int currentRoll(){
            return roll1 + roll2;
        }

    public boolean isDouble(){
            return roll1 == roll2;
        }
}
