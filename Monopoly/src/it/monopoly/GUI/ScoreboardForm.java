package it.monopoly.GUI;

import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ScoreboardForm {
    private JPanel[] j = new JPanel[40];
    private JPanel tabellonePanel;
    private JPanel playerPanel;
    private JList contractList;
    private JLabel nameLabel;
    private JLabel moneyLabel;
    private JButton shiftendButton;
    private JLabel shiftLabel;
    private JLabel proprietyLabel;
    private JButton diceButton;
    private JPanel buttonPanel;
    private JPanel infoPanel;
    private JButton payButton;
    private JLabel prisonLabel;
    private int shift = 0;
    private int totalshift = 0;

    //TODO fare un array o di panel o di label dove mi gestisco la posizione

    public ScoreboardForm(PlayerHandler giocatori,ScoreboardFrame scoreboardFrame){

        giocatori.setPlayerMoneyandContracts();

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

        contractList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                proprietyLabel.setText(contractList.getSelectedValue().toString());
                proprietyLabel.setForeground(Color.BLACK);
            }
        });
    }

    private void update_UI(PlayerHandler giocatori, int shift){
        nameLabel.setText(giocatori.getPlayer(shift).getUsername());
        moneyLabel.setText(giocatori.getPlayer(shift).getMoney() + "€");
        setContractsList(giocatori, shift);

    }

    private void setContractsList(PlayerHandler giocatori,int shiftplayer){
        DefaultListModel demoList = new DefaultListModel();
        for(int i = 0; i < giocatori.getPlayer(shiftplayer).getNumContracts(); i++){
            demoList.addElement(giocatori.getPlayer(shiftplayer).getContractList(i));
        }
        contractList.setModel(demoList);
    }

    public JPanel getPanel(){
        return tabellonePanel;
    }
}
