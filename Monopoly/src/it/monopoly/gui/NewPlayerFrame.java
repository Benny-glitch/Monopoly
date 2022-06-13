package it.monopoly.gui;

import javax.swing.*;
import java.awt.*;

public class NewPlayerFrame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    ImageIcon imgIcon = new ImageIcon("src/it/monopoly/pawns/easter-egg.png");
    public NewPlayerFrame(){
        super("Inserisci Nuovo Giocatore");
        setDeafultConfiguration();
        NewPlayerForm newPlayerForm = new NewPlayerForm(this);
        setContentPane(newPlayerForm.getPanel());
    }

    private void setDeafultConfiguration() {
        this.setIconImage(imgIcon.getImage());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }
}
