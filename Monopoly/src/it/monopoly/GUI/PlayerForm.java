package it.monopoly.GUI;

import javax.swing.*;

public class PlayerForm {

    private JPanel playerPanel;
    private JLabel turnoLabel;
    private JLabel soldLabel;
    private JList contrattiList;

    public PlayerForm(){

    }

    public JPanel getPanel(){
        return this.playerPanel;
    }

    private void createUIComponents() {
        String week[]= { "Monday","Tuesday","Wednesday",
                "Thursday","Friday","Saturday","Sunday"};
        //TODO qui inserisco i contratti che appartengono al giocatore
        contrattiList = new JList(week);

    }
}
