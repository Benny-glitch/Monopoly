package it.monopoly.gui;

import it.monopoly.Utils;
import it.monopoly.app.*;

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
    private JList contractsList;
    private JPanel contractsPanel;
    private JPanel dicePanel;
    private JLabel diceLabel;
    private JButton throwDiceButton;
    private JLabel exitPrisonMessage;
    private JLabel payRent;
    private JLabel playerRent;
    private JLabel rentToPay;
    private JLabel aLabel;
    private JLabel timerLabel;
    private JLabel payTaxLabel;
    private JLabel textTaxLabel;
    private JLabel contractLabel;
    private JPanel panel0;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;
    private JPanel panel12;
    private JPanel panel13;
    private JPanel panel14;
    private JPanel panel15;
    private JPanel panel16;
    private JPanel panel17;
    private JPanel panel18;
    private JPanel panel19;
    private JPanel panel20;
    private JPanel panel21;
    private JPanel panel22;
    private JPanel panel23;
    private JPanel panel24;
    private JPanel panel25;
    private JPanel panel26;
    private JPanel panel27;
    private JPanel panel28;
    private JPanel panel29;
    private JPanel panel30;
    private JPanel panel31;
    private JPanel panel32;
    private JPanel panel33;
    private JPanel panel34;
    private JPanel panel35;
    private JPanel panel36;
    private JPanel panel37;
    private JPanel panel38;
    private JPanel panel39;
    private final Dice dice;
    private int turnCounter;
    private int doub;
    private final List<JPanel> positions;

    private Timer timer;
    private int second;
    private int minute;
    ImageIcon imgIcon = new ImageIcon("src/it/monopoly/pawns/easter-egg.png");

    String ddSecond, ddMinute;

    DecimalFormat dFormat = new DecimalFormat("00");

    public ScoreBoardForm() {
        super("Tabellone");
        formWindowActivated();
        positions = new ArrayList<>();
        this.setVisible(true);
        dice = new Dice();
        setContentPane(this.getPanel());
        jailPanel.setVisible(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1500, 800));
        turnCounter = 0;
        update_UI();
        doub = 0;
        loadBoxes();
        setPosition();
        exitPrisonMessage.setVisible(false);
        payRent.setVisible(false);
        endTurnButton.setVisible(false);
        payTaxLabel.setVisible(false);
        textTaxLabel.setVisible(false);
        this.setIconImage(imgIcon.getImage());
        countDownTimer();
        setTimerLabel();

        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PlayerHandler.getInstance().getPlayer(turnCounter).isInJail())
                    timerLabel.hide();
                timer.start();

                int roll = dice.roll();
                diceLabel.setText(String.valueOf(roll));
                cleanPosition();
                PlayerHandler.getInstance().getPlayer(turnCounter).changePosition(roll);
                controlGoToJail(turnCounter);
                setPosition();

                if(PlayerHandler.getInstance().getPlayer(turnCounter).getMoney() <= 0)
                    PlayerHandler.getInstance().removePlayer(turnCounter);

                if (PlayerHandler.getInstance().getNumPlayer() == 1) {
                    win();
                } else {
                    if (GameHandler.getInstance().payRentCheck()) {
                        GameHandler.getInstance().payRent();
                        playerRent.setText(String.valueOf(BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).getOwner().getUsername()));
                        rentToPay.setText(BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).getRent() + "€");
                        payRent.setVisible(true);
                        playerRent.setVisible(true);
                        rentToPay.setVisible(true);
                        aLabel.setVisible(true);
                    } else if (!BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).isPurchased() && BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).getCanBeBought()) {
                        BuyPropriertiesFort buyPropriertiesFort =
                                new BuyPropriertiesFort(BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()), PlayerHandler.getInstance().getPlayer(turnCounter), contractsList, money);
                        buyPropriertiesFort.setVisible(true);
                        setContractsList();
                        update_UI();
                    } else if (BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).isATax()) {
                        payTaxLabel.setText(BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition()).getRent() + "€");
                        payTaxLabel.setVisible(true);
                        textTaxLabel.setVisible(true);
                        update_UI();
                    }
                }

                if (dice.isDouble())
                    doub++;
                else {
                    rollDiceButton.setVisible(false);
                    endTurnButton.setVisible(true);
                }

                if (doub == 3) {
                    PlayerHandler.getInstance().getPlayer(turnCounter).setIsInJail(true);
                }

                update_UI();
            }
        });

        endTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setTimerLabel();
                timer.stop();
                countDownTimer();
                payTaxLabel.setVisible(false);
                textTaxLabel.setVisible(false);
                payRent.setVisible(false);
                playerRent.setVisible(false);
                rentToPay.setVisible(false);
                aLabel.setVisible(false);
                doub = 0;
                payRent.setVisible(false);
                exitPrisonMessage.setVisible(false);
                cleanPosition();
                turnCounter = GameHandler.getInstance().turn();
                update_UI();
                rollDiceButton.setVisible(true);
                setPosition();
                endTurnButton.setVisible(false);
                if (PlayerHandler.getInstance().getPlayer(turnCounter).isInJail()) {
                    if (PlayerHandler.getInstance().getPlayer(turnCounter).getShiftsInJail() == 0) {
                        PlayerHandler.getInstance().getPlayer(turnCounter).buy(125);
                        PlayerHandler.getInstance().getPlayer(turnCounter).exitPrison();
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
                    GameHandler.getInstance().saveState();
                } catch (IOException ignored) {

                }
            }
        });

        payexitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerHandler.getInstance().getPlayer(turnCounter).buy(125);
                PlayerHandler.getInstance().getPlayer(turnCounter).exitPrison();
                rollDiceButton.setVisible(true);
                jailPanel.setVisible(false);
            }
        });

        throwDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = dice.roll();
                if (dice.isDouble()) {
                    PlayerHandler.getInstance().getPlayer(turnCounter).exitPrison();
                    rollDiceButton.setVisible(true);
                    jailPanel.setVisible(false);
                }
            }
        });
    }

    private void formWindowActivated() {
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

    private void setContractsList() {
        DefaultListModel demoList = new DefaultListModel();
        for (int i = 0; i < PlayerHandler.getInstance().getPlayer(turnCounter).getNumContracts(); i++) {
            demoList.addElement(PlayerHandler.getInstance().getPlayer(turnCounter).getContract(i));
        }
        contractsList.setModel(demoList);
    }

    private void setPosition() {
        for (int i = 0; i < PlayerHandler.getInstance().getNumPlayer(); i++) {
            JLabel pawn = new JLabel(Utils.getIcon(Utils.ICON_PATH + PlayerHandler.getInstance().getPlayer(i).getPawn().toLowerCase().replaceAll(" ", "") + "Pawn.png"));
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            pawn.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

            gridBagConstraints.weighty = 1;
            gridBagConstraints.weightx = 1;
            gridBagConstraints.fill = GridBagConstraints.BOTH;

            if (i < 3) {
                gridBagConstraints.gridx = i;
                gridBagConstraints.gridy = 1;
            } else {
                gridBagConstraints.gridx = i - 3;
                gridBagConstraints.gridy = 2;
            }
            ciao();
            JPanel card = positions.get(PlayerHandler.getInstance().getPlayer(i).getPosition());
            card.add(pawn, gridBagConstraints);
        }

    }

    private void cleanPosition() {
        JPanel card = positions.get(PlayerHandler.getInstance().getPlayer(turnCounter).getPosition());

        for (Component component : card.getComponents()) {
            if (component.getClass() == JLabel.class) {
                if (((JLabel) component).getText() == null)
                    card.remove(component);
            }
        }
        card.repaint();
    }

    private void loadBoxes() {
        positions.add(panel0);
        positions.add(panel1);
        positions.add(panel2);
        positions.add(panel3);
        positions.add(panel4);
        positions.add(panel5);
        positions.add(panel6);
        positions.add(panel7);
        positions.add(panel8);
        positions.add(panel9);
        positions.add(panel10);
        positions.add(panel11);
        positions.add(panel12);
        positions.add(panel13);
        positions.add(panel14);
        positions.add(panel15);
        positions.add(panel16);
        positions.add(panel17);
        positions.add(panel18);
        positions.add(panel19);
        positions.add(panel20);
        positions.add(panel21);
        positions.add(panel22);
        positions.add(panel23);
        positions.add(panel24);
        positions.add(panel25);
        positions.add(panel26);
        positions.add(panel27);
        positions.add(panel28);
        positions.add(panel29);
        positions.add(panel30);
        positions.add(panel31);
        positions.add(panel32);
        positions.add(panel33);
        positions.add(panel34);
        positions.add(panel35);
        positions.add(panel36);
        positions.add(panel37);
        positions.add(panel38);
        positions.add(panel39);
    }

    private void update_UI() {
        name.setText(GameHandler.getInstance().getPlayerUsername());
        money.setText(GameHandler.getInstance().getPlayerMoney() + "€");
        setContractsList();
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
    
    private void setTimerLabel(){
       timerLabel.setText("03:00");
    }


    private void ciao() {
        JPanel cell = positions.get(PlayerHandler.getInstance().getInstance().getPlayer(turnCounter).getPosition());
        for (Component component : cell.getComponents()) {

            if (((JLabel) component).getText() != null) {
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.weightx = 1;
                gridBagConstraints.weighty = 1;

                gridBagConstraints.gridwidth = 0;

                gridBagConstraints.fill = GridBagConstraints.BOTH;
                cell.add(component, gridBagConstraints);
            }

        }

        cell.repaint();
    }

    private void win() {
        timer.stop();
        if(JOptionPane.showConfirmDialog(
                this,
                "HAI VINTO",
                "Win message",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        ) == JOptionPane.OK_OPTION)
            System.exit(0);
            System.exit(0);
    }
}





