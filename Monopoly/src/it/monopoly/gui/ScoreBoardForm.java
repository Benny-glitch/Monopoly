package it.monopoly.gui;

import it.monopoly.app.Dice;
import it.monopoly.app.BoxesHandler;
import it.monopoly.app.PlayerHandler;
import it.monopoly.app.Turn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ScoreBoardForm extends JFrame {
    private JPanel turnPanel;
    private JPanel scoreBoardPanel;
    private JLabel name;
    private JLabel money;
    private JButton rollDiceButton;
    private JButton endTurnButton;
    private JPanel boardPanel;
    private JButton payexitButton;
    private JPanel jailPanel;
    private JList<it.monopoly.app.Boxes> contractsList;
    private JPanel contractsPanel;
    private JPanel dicePanel;
    private JLabel diceLabel;
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
    private JButton throwDiceButton;
    private JLabel exitPrisonMessage;
    private JLabel payRent;
    private JLabel playerRent;
    private JLabel rentToPay;
    private JLabel aLabel;
    private JLabel timerLabel;
    private JLabel payTaxLabel;
    private JLabel textTaxLabel;
    private final Dice dice;
    private final Turn turn;
    private int turnCounter;
    private int doub;
    private final List<JLabel> positions;

    private Timer timer;
    private int second;
    private int minute;
    ImageIcon imgIcon = new ImageIcon("src/it/monopoly/pawns/easter-egg.png");

    String ddSecond, ddMinute;

    DecimalFormat dFormat = new DecimalFormat("00");

    public ScoreBoardForm(BoxesHandler boxesHandler, PlayerHandler playerHandler) {
        super("Tabellone");
        formWindowActivated();
        positions = new ArrayList<>();
        this.setVisible(true);
        dice = new Dice();
        turn = new Turn(playerHandler);
        setContentPane(this.getPanel());
        jailPanel.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1500, 800));
        turnCounter = 0;
        update_UI(playerHandler, turnCounter);
        doub = 0;
        loadBoxes();
        setPosition(turnCounter);
        exitPrisonMessage.setVisible(false);
        payRent.setVisible(false);
        endTurnButton.setVisible(false);
        payTaxLabel.setVisible(false);
        textTaxLabel.setVisible(false);
        this.setIconImage(imgIcon.getImage());

        countDownTimer();
        timerLabel.setText("03:00");

        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();

                int roll = dice.roll();
                diceLabel.setText(String.valueOf(roll));
                cleanPosition(turnCounter);
                playerHandler.getPlayer(turnCounter).changePosition(roll);
                controlGoToJail(turnCounter);
                setPosition(turnCounter);


                if (boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).isPurchased() &&
                        boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getOwner() != null) {
                    playerHandler.getPlayer(turnCounter).pay(boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getOwner(),
                            boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getRent());
                    playerRent.setText(String.valueOf(boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getOwner().getUsername()));
                    rentToPay.setText(boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getRent() + "€");
                    payRent.setVisible(true);
                    playerRent.setVisible(true);
                    rentToPay.setVisible(true);
                    aLabel.setVisible(true);
                } else if (!boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).isPurchased() && boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getCanBeBought()) {
                    AcquistaProprietaForm acquistaProprietaForm =
                            new AcquistaProprietaForm(boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()), playerHandler.getPlayer(turnCounter), contractsList, money);
                    acquistaProprietaForm.setVisible(true);

                    setContractsList(turnCounter);
                } else if (boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).isATax()) {
                    payTaxLabel.setText(boxesHandler.get(playerHandler.getPlayer(turnCounter).getPosition()).getRent() + "€");
                    payTaxLabel.setVisible(true);
                    textTaxLabel.setVisible(true);
                    update_UI(playerHandler, turnCounter);
                }


                if (dice.isDouble())
                    doub++;
                else {
                    rollDiceButton.setVisible(false);
                    endTurnButton.setVisible(true);
                }


                if (doub == 3) {
                    playerHandler.getPlayer(turnCounter).setIsInJail(true);
                }

                update_UI(playerHandler, turnCounter);
            }
        });

        endTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("03:00");
                timer.stop();
                countDownTimer();
                payRent.setVisible(false);
                playerRent.setVisible(false);
                rentToPay.setVisible(false);
                aLabel.setVisible(false);
                doub = 0;
                payRent.setVisible(false);
                exitPrisonMessage.setVisible(false);
                cleanPosition(turnCounter);
                turnCounter = turn.Turns();
                update_UI(playerHandler, turnCounter);
                rollDiceButton.setVisible(true);
                setPosition(turnCounter);
                endTurnButton.setVisible(false);
                if (playerHandler.getPlayer(turnCounter).isInJail()) {
                    if (playerHandler.getPlayer(turnCounter).getShiftsInJail() == 0) {
                        playerHandler.getPlayer(turnCounter).buy(125);
                        playerHandler.getPlayer(turnCounter).exitPrison();
                        rollDiceButton.setVisible(true);
                        jailPanel.setVisible(false);
                        exitPrisonMessage.setVisible(true);
                    } else {
                        jailPanel.setVisible(true);
                        rollDiceButton.setVisible(false);
                    }
                } else
                    jailPanel.setVisible(false);

                try {
                    playerHandler.saveState();
                    boxesHandler.saveState();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        payexitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerHandler.getPlayer(turnCounter).buy(125);
                playerHandler.getPlayer(turnCounter).exitPrison();
                rollDiceButton.setVisible(true);
                jailPanel.setVisible(false);
            }
        });

        throwDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = dice.roll();
                if (dice.isDouble()) {
                    playerHandler.getPlayer(turnCounter).exitPrison();
                    rollDiceButton.setVisible(true);
                    jailPanel.setVisible(false);
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

    public void controlGoToJail(int i) {
        if (PlayerHandler.getInstance().getPlayer(i).getPosition() == 30) {
            PlayerHandler.getInstance().getPlayer(i).setIsInJail(true);
            jailPanel.setVisible(true);
            rollDiceButton.setVisible(false);
        }
    }

    public JPanel getPanel() {
        return this.scoreBoardPanel;
    }

    private void setContractsList(int shiftplayer) {
        DefaultListModel<it.monopoly.app.Boxes> demoList = new DefaultListModel<it.monopoly.app.Boxes>();
        for (int i = 0; i < PlayerHandler.getInstance().getPlayer(shiftplayer).getNumContracts(); i++) {
            demoList.addElement(PlayerHandler.getInstance().getPlayer(shiftplayer).getContract(i));
        }
        contractsList.setModel(demoList);
    }

    private void setPosition(int i) {
        positions.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText(PlayerHandler.getInstance().getPlayer(i).getPawn());
    }

    private void cleanPosition(int i) {
        positions.get(PlayerHandler.getInstance().getPlayer(i).getPosition()).setText("");
    }


    private void loadBoxes() {
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

    private void update_UI(PlayerHandler giocatori1, int shift) {
        name.setText(giocatori1.getPlayer(shift).getUsername());
        money.setText(giocatori1.getPlayer(shift).getMoney() + "€");
        setContractsList(shift);
    }

    private void countDownTimer() {
        minute = 3;
        second = 0;
        timer = new Timer(1000, (ActionListener) e -> {
            second--;
            ddSecond = dFormat.format(second);
            ddMinute = dFormat.format(minute);

            timerLabel.setText(ddMinute + ":" + ddSecond);

            if (second == -1) {
                second = 59;
                minute--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);

                timerLabel.setText(ddMinute + ":" + ddSecond);
            }

            if (minute == 0 && second == 0) {
                endTurnButton.doClick();
            }
        });
    }

}