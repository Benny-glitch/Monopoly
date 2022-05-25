package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class NewPlayerFrame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);

    public NewPlayerFrame(){
        super("Inserisci Nuovo Giocatore");
        setDeafultConfiguration();
        NewPlayerForm newPlayerForm = new NewPlayerForm(this);
        setContentPane(newPlayerForm.getPanel());
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }



}
