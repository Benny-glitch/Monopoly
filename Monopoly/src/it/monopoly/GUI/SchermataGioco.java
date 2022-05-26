package it.monopoly.GUI;

import it.monopoly.app.*;
import it.monopoly.app.Dado;
import it.monopoly.app.ContractsHandler;
import it.monopoly.app.PlayerHandler;
import it.monopoly.app.Turno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchermataGioco extends JFrame{
    private JPanel turnPanel;
    private JPanel SchermataGiocoPanel;
    private JLabel nome;
    private JLabel saldo;
    private JButton tiraIDadiButton;
    private JButton terminaTurnoButton;
    private JPanel tabellonePanel;
    private JButton pagaUscitaPrigioneButton;
    private JPanel PrigionePanel;
    private JList contrattiList;
    private JPanel contrattiPanel;
    private JPanel dadoPanel;
    private JLabel dadoLabel;
    private JLabel casella20;
    private JLabel casella19;
    private JLabel casella18;
    private JLabel casella17;
    private JLabel casella16;
    private JLabel casella15;
    private JLabel casella14;
    private JLabel casella13;
    private JLabel casella12;
    private JLabel casella11;
    private JLabel casella10;
    private JLabel casella9;
    private JLabel casella8;
    private JLabel casella7;
    private JLabel casella6;
    private JLabel casella5;
    private JLabel casella4;
    private JLabel casella3;
    private JLabel casella2;
    private JLabel casella1;
    private JLabel casella0;
    private JLabel casella39;
    private JLabel casella21;
    private JLabel casella22;
    private JLabel casella23;
    private JLabel casella24;
    private JLabel casella25;
    private JLabel casella26;
    private JLabel casella27;
    private JLabel casella28;
    private JLabel casella29;
    private JLabel casella30;
    private JLabel casella31;
    private JLabel casella32;
    private JLabel casella33;
    private JLabel casella34;
    private JLabel casella35;
    private JLabel casella36;
    private JLabel casella37;
    private JLabel casella38;
    private JButton lanciaDadiButton;
    private JLabel messaggioUscitaPrigione;
    private JLabel pagatoAffitto;
    private JLabel giocatoreAffitto;
    private JLabel denaroAffitto;
    private int giocatoriInGioco;
    private Dado dadi;
    private Turno turno;
    private int i;
    private int doub;
    private List<JLabel> posizioni;

    public SchermataGioco(ContractsHandler caselle, PlayerHandler giocatori){
        super();
        posizioni = new ArrayList<>();
        this.setVisible(true);
        dadi = new Dado();
        turno = new Turno(giocatori);
        setContentPane(this.getPanel());
        PrigionePanel.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1500, 800));
        i = 0;
        update_UI(giocatori, i);
        doub = 0;
        caricaCaselle();
        setPosition(i);
        messaggioUscitaPrigione.setVisible(false);
        pagatoAffitto.setVisible(false);
        terminaTurnoButton.setVisible(false);


        tiraIDadiButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    int roll = dadi.roll();
                    dadoLabel.setText(String.valueOf(roll));
                    cleanPosition(i);
                    giocatori.getPlayer(i).changePosition(roll);
                    controlloVaiInPrigione(i);
                    setPosition(i);

                    if(caselle.get(giocatori.getPlayer(i).getPosition()).getPurchased() &&
                            caselle.get(giocatori.getPlayer(i).getPosition()).getOwner() != null) {
                        giocatori.getPlayer(i).pay(caselle.get(giocatori.getPlayer(i).getPosition()).getOwner(),
                                caselle.get(giocatori.getPlayer(i).getPosition()).getRent());
                        giocatoreAffitto.setText(String.valueOf(caselle.get(giocatori.getPlayer(i).getPosition()).getOwner()));
                        denaroAffitto.setText(caselle.get(giocatori.getPlayer(i).getPosition()).getRent() + "€");
                        pagatoAffitto.setVisible(true);
                        giocatoreAffitto.setVisible(true);
                        denaroAffitto.setVisible(true);
                    }
                    /*else
                        if (!caselle.get(giocatori.getPlayer(i).getPosition()).getPurchased()){
                            AcquistaProprietaForm acquistaProprietaForm =
                                    new AcquistaProprietaForm(caselle.(giocatori.getPlayer(i).getPosition()), giocatori.(i), contrattiList, saldo);
                            acquistaProprietaForm.setVisible(true);

                            update_UI(giocatori, i);
                            setContractsList(giocatori, i);
                        }
*/

                    if(dadi.isDouble())
                        doub++;
                    else {
                        tiraIDadiButton.setVisible(false);
                        terminaTurnoButton.setVisible(true);
                    }


                if (doub == 3) {
                    giocatori.getPlayer(i).setIsInJail(true);
                }

                update_UI(giocatori, i);
            }
        });
        terminaTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doub = 0;
                pagatoAffitto.setVisible(false);
                messaggioUscitaPrigione.setVisible(false);
                cleanPosition(i);
                i = turno.Turni();
                update_UI(giocatori, i);
                tiraIDadiButton.setVisible(true);
                setPosition(i);
                terminaTurnoButton.setVisible(false);
                if(giocatori.getPlayer(i).getIsInJail()) {
                    if(giocatori.getPlayer(i).getShiftsinjail() == 0){
                        giocatori.getPlayer(i).buy(125);
                        giocatori.getPlayer(i).exitPrison();
                        tiraIDadiButton.setVisible(true);
                        PrigionePanel.setVisible(false);
                        messaggioUscitaPrigione.setVisible(true);
                    }
                    else {
                        PrigionePanel.setVisible(true);
                        tiraIDadiButton.setVisible(false);
                    }
                }
                else
                    PrigionePanel.setVisible(false);

                /*try {
                    giocatori.salvaStato();
                    caselle.salvaStato();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            }
        });
        pagaUscitaPrigioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giocatori.getPlayer(i).buy(125);
                giocatori.getPlayer(i).exitPrison();
                tiraIDadiButton.setVisible(true);
                PrigionePanel.setVisible(false);
            }
        });
        lanciaDadiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = dadi.roll();
                if(dadi.isDouble()){
                    giocatori.getPlayer(i).exitPrison();
                    tiraIDadiButton.setVisible(true);
                    PrigionePanel.setVisible(false);
                }
            }
        });
    }

    /*public void muovi(int i){
            int pos = giocatori.get(i).getPosizione();

            for(int j = 0; j < 40; j++) {
                if(caselle.get(j).getPosizionesulTabellone() == pos){
                    if(!caselle.get(j).getAcquistato())
                    {AcquistaProprietaForm acquistaProprietaForm = new AcquistaProprietaForm(caselle.get(j), giocatori.get(i));
                        acquistaProprietaForm.setVisible(true);
                    }
                } else
                {
                    giocatori.get(i).paga(caselle.get(j).getProprietario(), caselle.get(j).getAffitto());
                }
            }



    }*/

    public void controlloVaiInPrigione(int i){
        if(PlayerHandler.getInstance().getPlayer(i).getPosition() == 30){
            PlayerHandler.getInstance().getPlayer(i).setIsInJail(true);
            PrigionePanel.setVisible(true);
            tiraIDadiButton.setVisible(false);
        }
    }

    public JPanel getPanel(int i){
        if(PlayerHandler.getInstance().getPlayer(i).getIsInJail()){

        }else{

        } return turnPanel;
    }

    public JPanel getPanel(){
        return this.SchermataGiocoPanel;
    }

    private void setContractsList(PlayerHandler giocatori,int shiftplayer){
        DefaultListModel demoList = new DefaultListModel();
        for(int i = 0; i < giocatori.getPlayer(shiftplayer).getNumContracts(); i++){
            demoList.addElement(giocatori.getPlayer(shiftplayer).getContract(i));
        }
        contrattiList.setModel(demoList);
    }

    private void setPosition(int i){
        posizioni.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText(PlayerHandler.getInstance().getPlayer(i).getPawn());
    }

    private void cleanPosition(int i){
        posizioni.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText("");
    }


    private void caricaCaselle(){
        posizioni.add(casella0);
        posizioni.add(casella1);
        posizioni.add(casella2);
        posizioni.add(casella3);
        posizioni.add(casella4);
        posizioni.add(casella5);
        posizioni.add(casella6);
        posizioni.add(casella7);
        posizioni.add(casella8);
        posizioni.add(casella9);
        posizioni.add(casella10);
        posizioni.add(casella11);
        posizioni.add(casella12);
        posizioni.add(casella13);
        posizioni.add(casella14);
        posizioni.add(casella15);
        posizioni.add(casella16);
        posizioni.add(casella17);
        posizioni.add(casella18);
        posizioni.add(casella19);
        posizioni.add(casella20);
        posizioni.add(casella21);
        posizioni.add(casella22);
        posizioni.add(casella23);
        posizioni.add(casella24);
        posizioni.add(casella25);
        posizioni.add(casella26);
        posizioni.add(casella27);
        posizioni.add(casella28);
        posizioni.add(casella29);
        posizioni.add(casella30);
        posizioni.add(casella31);
        posizioni.add(casella32);
        posizioni.add(casella33);
        posizioni.add(casella34);
        posizioni.add(casella35);
        posizioni.add(casella36);
        posizioni.add(casella37);
        posizioni.add(casella38);
        posizioni.add(casella39);
    }

    private void update_UI(PlayerHandler giocatori1, int shift){
        nome.setText(giocatori1.getPlayer(shift).getUsername());
        saldo.setText(giocatori1.getPlayer(shift).getMoney() + "€");
        setContractsList(giocatori1, shift);
    }
}

