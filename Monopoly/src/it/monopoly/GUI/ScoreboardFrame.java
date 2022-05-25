package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class ScoreboardFrame extends JFrame{
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);

    public ScoreboardFrame(){
        super("Tabellone");
        ScoreboardForm scoreboardForm = new ScoreboardForm();
        setContentPane(scoreboardForm.getPanel());
        setDeafultConfiguration();
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }



}
