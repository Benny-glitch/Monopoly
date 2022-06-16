package it.monopoly.gui;

import it.monopoly.app.Boxes;
import it.monopoly.app.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyPropriertiesForm extends JFrame {
    private JButton siButton;
    private JButton noButton;
    private JPanel AcquistaProprietàPanel;
    private JLabel prezzo;
    private JLabel labelContratto;

    public BuyPropriertiesForm(Boxes contratto, Player giocatore, JList contratti, JLabel saldo) {
        super();
        this.setVisible(true);
        setContentPane(this.getPanel());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 400));
        labelContratto.setText(contratto.getName());
        prezzo.setText(contratto.getPrice() + "€");

        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giocatore.buyContracts(contratto);
                contratto.setPurchased();
                contratto.setOwner(giocatore);
                setContractsList(giocatore, contratti);
                saldo.setText(String.valueOf(giocatore.getMoney()));
                revalidate();
                dispose();
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public JPanel getPanel() {
        return this.AcquistaProprietàPanel;
    }

    private void setContractsList(Player giocatore, JList contratti) {
        DefaultListModel demoList = new DefaultListModel();
        for (int i = 0; i < giocatore.getNumContracts(); i++) {
            demoList.addElement(giocatore.getContract(i));
        }
        contratti.setModel(demoList);
    }
}
