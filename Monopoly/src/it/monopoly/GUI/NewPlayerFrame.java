package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class NewPlayerFrame extends JFrame {

    public NewPlayerFrame(){
        super();
        NewPlayerForm newPlayerForm = new NewPlayerForm();
        setTitle("Inserisci Nuovo Giocatore");
        setContentPane(newPlayerForm.getPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500,800));
    }

}
