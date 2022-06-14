package it.monopoly.gui;

import it.monopoly.app.BoxesHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class ScoreboardFrame extends JFrame{
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    private BoxesHandler boxesHandler;
    ImageIcon imgIcon = new ImageIcon("src/it/monopoly/pawns/easter-egg.png");

    public ScoreboardFrame(PlayerHandler playerHandler) throws FileNotFoundException {
        super("Tabellone");
        boxesHandler = BoxesHandler.getInstance();
        ScoreBoardForm scoreboardForm = new ScoreBoardForm(boxesHandler,playerHandler);
        setContentPane(scoreboardForm.getPanel());
        setDeafultConfiguration();
    }

    private void setDeafultConfiguration() {
        this.setIconImage(imgIcon.getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
