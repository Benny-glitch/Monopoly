package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class NewPlayerFrame extends JFrame {

    public NewPlayerFrame(){
        super();
        NewPlayerForm newPlayerForm = new NewPlayerForm(this);
        setTitle("Inserisci Nuovo Giocatore");
        setContentPane(newPlayerForm.getPanel());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
    }


    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

}
