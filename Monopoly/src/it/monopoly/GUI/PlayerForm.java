package it.monopoly.GUI;

import it.monopoly.app.PlayerHandler;

import javax.swing.*;

public class PlayerForm {

    private JPanel playerPanel;
    private JLabel turnoLabel;
    private JLabel soldLabel;
    private JList contrattiList;
    private JButton shiftendButton;
    private JLabel shiftLabel;
    private int shift = 0;
    private int totalshift = 0;


    public PlayerForm(PlayerHandler giocatori, PlayerFrame playerFrame){

        giocatori.setPlayer_Money_and_Contracts();

        update_UI(giocatori, shift);

        setContractsList(giocatori,shift);

        shiftendButton.addActionListener(e -> {
            if(shift <= giocatori.getNumPlayer()-2){
                shift++;
            }else{
                shift = 0;
            }
            totalshift++;
            update_UI(giocatori, shift);
            shiftLabel.setText(String.valueOf(totalshift));
        });

    }

    private void update_UI(PlayerHandler giocatori, int shift){
        turnoLabel.setText(giocatori.getPlayer(shift).getUsername());
        soldLabel.setText(giocatori.getPlayer(shift).getMoney() + "€");
        setContractsList(giocatori, shift);

    }

    private void setContractsList(PlayerHandler giocatori,int shiftplayer){
        DefaultListModel demoList = new DefaultListModel();
        for(int i = 0; i < giocatori.getPlayer(shiftplayer).get_Num_Contracts(); i++){
            demoList.addElement(giocatori.getPlayer(shiftplayer).get_ContractList(i));
        }
        contrattiList.setModel(demoList);
    }

    public JPanel getPanel(){
        return this.playerPanel;
    }

}
