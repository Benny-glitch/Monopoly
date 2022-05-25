package it.monopoly.GUI;

import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;

public class PlayerFrame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(500,800);

    public PlayerFrame(PlayerHandler playerHandler){
        super("Giocatore");
        PlayerForm playerForm = new PlayerForm(playerHandler, this);
        setContentPane(playerForm.getPanel());
        setDeafultConfiguration();
        formWindowActivated();
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }


    private void formWindowActivated() {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = -900;
        int h = 1000;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        this.setLocation(x, y);
    }


}
