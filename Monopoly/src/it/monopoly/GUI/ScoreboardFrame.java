package it.monopoly.GUI;

import it.monopoly.app.BoxesHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;

public class ScoreboardFrame extends JFrame{
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    private BoxesHandler boxesHandler;
    public ScoreboardFrame(PlayerHandler playerHandler){
        super("Tabellone");
        boxesHandler = new BoxesHandler();
        ScoreBoardForm scoreboardForm = new ScoreBoardForm(boxesHandler,playerHandler);
        setContentPane(scoreboardForm.getPanel());
        setDeafultConfiguration();
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
