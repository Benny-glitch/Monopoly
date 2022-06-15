package it.monopoly.app;

import javax.swing.*;
import java.util.Random;

/**
 * Singleton che rappresenta il dado che il giocatore lancia attraverso il metodo {@link #roll()}.
 *
 * Esempio: {@code Dice.roll();}
 *
 * @author Benny
 */
public class Dice {
    private final int max_bound = 6;
    private final int min_bound = 1;
    private int roll1;
    private int roll2;
    private Random random;
    private Timer timer;

    public Dice() {
        random = new Random();
    }

    /**
     * Restituisce la somma di due valori interi calcolati attraverso la funzione random {@link Random} che vanno da un minimo di 1 ad un massimo di 6.
     * @return la somma di due valori interi calcolati attraverso la funzione random.
     */
    public int roll() {
        roll1 = random.nextInt(max_bound - min_bound) + min_bound;
        roll2 = random.nextInt(max_bound - min_bound) + min_bound;

        return roll1 + roll2;
    }

    public int currentRoll() {
        return roll1 + roll2;
    }

    public boolean isDouble() {
        return roll1 == roll2;
    }

}
