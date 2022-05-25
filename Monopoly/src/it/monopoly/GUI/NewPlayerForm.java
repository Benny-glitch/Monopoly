package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import it.monopoly.Utils;
import it.monopoly.app.NullNameException;
import it.monopoly.app.PlayerHandler;

public class NewPlayerForm extends JFrame {

    private JPanel newplayerForm;
    private JPanel playerimagesPanel;

    private JLabel annullaLabel;
    private JLabel inserisciLabel;
    private JComboBox pedinaCombobox;
    private JLabel nomeLabel;
    private JLabel pedinaLabel;
    private JLabel imageLabelp1;
    private JLabel imageLabelp2;
    private JLabel imageLabelp3;
    private JLabel imageLabelp4;
    private JLabel imageLabelp5;
    private JLabel imageLabelp6;
    private JLabel nameLabelp1;
    private JLabel nameLabelp2;
    private JLabel nameLabelp3;
    private JLabel nameLabelp4;
    private JLabel nameLabelp5;
    private JLabel nameLabelp6;
    private JTextField nameTextFileld;
    private JLabel avviagiocoLabel;
    private JLabel maxplayerLabel;
    private JLabel imagepawnLabel;
    private JButton annullaButton;
    private Font font;
    private Utils utils;
    private PlayerHandler playerHandler;


    public NewPlayerForm(NewPlayerFrame newPlayerFrame) {
        playerHandler = PlayerHandler.getInstance();
        utils = Utils.getInstance();

        setFontStartUP();

        inserisciLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (playerHandler.getNumPlayer() <= 6) {
                    try {
                        playerHandler.addPlayer(
                                nameTextFileld.getText(),
                                pedinaCombobox.getSelectedIndex());

                        int x = pedinaCombobox.getSelectedIndex();
                        pedinaCombobox.removeItemAt(x);
                        nameTextFileld.setText("");
                    } catch (NullNameException ex) {
                        JOptionPane.showMessageDialog(
                                newplayerForm,
                                "Errore nel nome campo non compilato",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                    } /*catch (IOException ex) {
                        JOptionPane.showMessageDialog(
                                newplayerForm,
                                "Errore nello stato del salvataggio del gioco",
                                "Errore",
                                JOptionPane.ERROR_MESSAGE);
                    }*/
                } else {
                    JOptionPane.showMessageDialog(
                            newplayerForm,
                            "Numero di giocatori massimo raggiunto",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE);
                }
                System.out.println(playerHandler.getNumPlayer());
            }

        });

        annullaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newPlayerFrame.dispose();
            }
        });

        avviagiocoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (playerHandler.getNumPlayer() < 2) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Numero di giocatori troppo basso",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    PlayerFrame playerFrame = new PlayerFrame(playerHandler);
                    ScoreboardFrame scoreboardFrame = new ScoreboardFrame();
                    playerFrame.setVisible(true);
                    scoreboardFrame.setVisible(true);
                    newPlayerFrame.dispose();
                }
            }
        });

        pedinaCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int x = pedinaCombobox.getSelectedIndex();
                    imagepawnLabel.setIcon(utils.getIcons(x));
                    System.out.println(imagepawnLabel.getIcon() + imagepawnLabel.getSize().toString());
                    newPlayerFrame.pack();
                }catch (IndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(
                            null,
                            "Numero di giocatori troppo basso",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void setImageName(int x) {
        //TODO da fare setta il nome e immagine del player
    }

    public JPanel getPanel() {
        return newplayerForm;
    }

    private void setFontStartUP() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/it/monopoly/fonts/KabelBd-Normal.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        imageLabelp1.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp2.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp3.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp4.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp5.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp6.setFont(font.deriveFont(Font.PLAIN, 36));
        annullaLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        inserisciLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        avviagiocoLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        nomeLabel.setFont(font.deriveFont(Font.PLAIN, 15));
        pedinaLabel.setFont(font.deriveFont(Font.PLAIN, 15));

    }
}
