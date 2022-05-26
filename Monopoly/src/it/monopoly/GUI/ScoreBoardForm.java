package it.monopoly.GUI;

import it.monopoly.app.Dado;
import it.monopoly.app.ContractsHandler;
import it.monopoly.app.PlayerHandler;
import it.monopoly.app.Turno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoardForm extends JFrame{
    private JPanel turnPanel;
    private JPanel SchermataGiocoPanel;
    private JLabel nome;
    private JLabel saldo;
    private JButton rolldiceButton;
    private JButton endturnButton;
    private JPanel tabellonePanel;
    private JButton payexitButton;
    private JPanel JailPanel;
    private JList contrattiList;
    private JPanel contrattiPanel;
    private JPanel dicePanel;
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
    private final Dado dice;
    private final Turno turn;
    private int i;
    private int doub;
    private final List<JLabel> positions;

    public ScoreBoardForm(ContractsHandler boxes, PlayerHandler giocatori){
        super("Tabellone");
        formWindowActivated();
        positions = new ArrayList<>();
        this.setVisible(true);
        dice = new Dado();
        turn = new Turno(giocatori);
        setContentPane(this.getPanel());
        JailPanel.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1500, 800));
        i = 0;
        update_UI(giocatori, i);
        doub = 0;
        loadBoxes();
        setPosition(i);
        messaggioUscitaPrigione.setVisible(false);
        pagatoAffitto.setVisible(false);
        endturnButton.setVisible(false);


        rolldiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    int roll = dice.roll();
                    dadoLabel.setText(String.valueOf(roll));
                    cleanPosition(i);
                    giocatori.getPlayer(i).changePosition(roll);
                    controlGoToJail(i);
                    setPosition(i);

                    if(boxes.get(giocatori.getPlayer(i).getPosition()).getPurchased() &&
                            boxes.get(giocatori.getPlayer(i).getPosition()).getOwner() != null) {
                        giocatori.getPlayer(i).pay(boxes.get(giocatori.getPlayer(i).getPosition()).getOwner(),
                                boxes.get(giocatori.getPlayer(i).getPosition()).getRent());
                        giocatoreAffitto.setText(String.valueOf(boxes.get(giocatori.getPlayer(i).getPosition()).getOwner().getUsername()));
                        denaroAffitto.setText(boxes.get(giocatori.getPlayer(i).getPosition()).getRent() + "€");
                        pagatoAffitto.setVisible(true);
                        giocatoreAffitto.setVisible(true);
                        denaroAffitto.setVisible(true);
                    }
                    else
                        if (!boxes.get(giocatori.getPlayer(i).getPosition()).getPurchased()){
                            AcquistaProprietaForm acquistaProprietaForm =
                                    new AcquistaProprietaForm(boxes.get(giocatori.getPlayer(i).getPosition()),giocatori.getPlayer(i), contrattiList, saldo);
                            acquistaProprietaForm.setVisible(true);

                            update_UI(giocatori, i);
                            setContractsList(giocatori, i);
                        }


                    if(dice.isDouble())
                        doub++;
                    else {
                        rolldiceButton.setVisible(false);
                        endturnButton.setVisible(true);
                    }


                if (doub == 3) {
                    giocatori.getPlayer(i).setIsInJail(true);
                }

                update_UI(giocatori, i);
            }
        });

        endturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doub = 0;
                pagatoAffitto.setVisible(false);
                messaggioUscitaPrigione.setVisible(false);
                cleanPosition(i);
                i = turn.Turni();
                update_UI(giocatori, i);
                rolldiceButton.setVisible(true);
                setPosition(i);
                endturnButton.setVisible(false);
                if(giocatori.getPlayer(i).getIsInJail()) {
                    if(giocatori.getPlayer(i).getShiftsinjail() == 0){
                        giocatori.getPlayer(i).buy(125);
                        giocatori.getPlayer(i).exitPrison();
                        rolldiceButton.setVisible(true);
                        JailPanel.setVisible(false);
                        messaggioUscitaPrigione.setVisible(true);
                    }
                    else {
                        JailPanel.setVisible(true);
                        rolldiceButton.setVisible(false);
                    }
                }
                else
                    JailPanel.setVisible(false);

                /*try {
                    giocatori.salvaStato();
                    boxes.salvaStato();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            }
        });
        payexitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giocatori.getPlayer(i).buy(125);
                giocatori.getPlayer(i).exitPrison();
                rolldiceButton.setVisible(true);
                JailPanel.setVisible(false);
            }
        });
        lanciaDadiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = dice.roll();
                if(dice.isDouble()){
                    giocatori.getPlayer(i).exitPrison();
                    rolldiceButton.setVisible(true);
                    JailPanel.setVisible(false);
                }
            }
        });
    }

    private void formWindowActivated() {
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setMinimumSize(dim);
        this.setPreferredSize(dim);
    }

    public void controlGoToJail(int i){
        if(PlayerHandler.getInstance().getPlayer(i).getPosition() == 30){
            PlayerHandler.getInstance().getPlayer(i).setIsInJail(true);
            JailPanel.setVisible(true);
            rolldiceButton.setVisible(false);
        }
    }

    public JPanel getPanel(){
        return this.SchermataGiocoPanel;
    }

    private void setContractsList(PlayerHandler giocatori,int shiftplayer){
        DefaultListModel demoList = new DefaultListModel();
        for(int i = 0; i < PlayerHandler.getInstance().getPlayer(shiftplayer).getNumContracts(); i++){
            demoList.addElement(PlayerHandler.getInstance().getPlayer(shiftplayer).getContract(i));
        }
        contrattiList.setModel(demoList);
    }

    private void setPosition(int i){
        positions.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText(PlayerHandler.getInstance().getPlayer(i).getPawn());
    }

    private void cleanPosition(int i){
        positions.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText("");
    }


    private void loadBoxes(){
        positions.add(casella0);
        positions.add(casella1);
        positions.add(casella2);
        positions.add(casella3);
        positions.add(casella4);
        positions.add(casella5);
        positions.add(casella6);
        positions.add(casella7);
        positions.add(casella8);
        positions.add(casella9);
        positions.add(casella10);
        positions.add(casella11);
        positions.add(casella12);
        positions.add(casella13);
        positions.add(casella14);
        positions.add(casella15);
        positions.add(casella16);
        positions.add(casella17);
        positions.add(casella18);
        positions.add(casella19);
        positions.add(casella20);
        positions.add(casella21);
        positions.add(casella22);
        positions.add(casella23);
        positions.add(casella24);
        positions.add(casella25);
        positions.add(casella26);
        positions.add(casella27);
        positions.add(casella28);
        positions.add(casella29);
        positions.add(casella30);
        positions.add(casella31);
        positions.add(casella32);
        positions.add(casella33);
        positions.add(casella34);
        positions.add(casella35);
        positions.add(casella36);
        positions.add(casella37);
        positions.add(casella38);
        positions.add(casella39);
    }

    private void update_UI(PlayerHandler giocatori1, int shift){
        nome.setText(giocatori1.getPlayer(shift).getUsername());
        saldo.setText(giocatori1.getPlayer(shift).getMoney() + "€");
        setContractsList(giocatori1, shift);
    }
}

