package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class PlayerFrame extends JFrame {

    public PlayerFrame(){
        super();
        PlayerForm playerForm = new PlayerForm();
        setTitle("Inserisci Giocatore");
        setContentPane(playerForm.getPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500,800));
        formWindowActivated();
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
