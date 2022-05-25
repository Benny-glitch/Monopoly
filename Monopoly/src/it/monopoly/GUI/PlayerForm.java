package it.monopoly.GUI;

import it.monopoly.app.GestoreGiocatori;

import javax.swing.*;

public class PlayerForm {

    private JPanel playerPanel;
    private JLabel turnoLabel;
    private JLabel soldLabel;
    private JList contrattiList;
    private DefaultListModel demoList;

    public PlayerForm(GestoreGiocatori giocatori){
        demoList = new DefaultListModel();
        giocatori.setGiocatoreSoldiEcontratti();
        for(int i = 0; i < 5; i++){
            demoList.addElement(giocatori.getGiocatore(0).get_listContratti(i));
        }
        turnoLabel.setText(giocatori.getGiocatore(0).getUsername());
        soldLabel.setText(giocatori.getGiocatore(0).getMoney() + "€");

        contrattiList.setModel(demoList);
    }

    public JPanel getPanel(){
        return this.playerPanel;
    }

}
