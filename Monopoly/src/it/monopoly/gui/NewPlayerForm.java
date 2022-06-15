package it.monopoly.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
<<<<<<< Updated upstream
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
=======
import java.io.*;
>>>>>>> Stashed changes

import it.monopoly.Utils;
import it.monopoly.app.BoxesHandler;
import it.monopoly.app.NullNameException;
import it.monopoly.app.PlayerHandler;

public class NewPlayerForm extends JFrame {

    private JPanel newplayerForm;
    private JPanel playerimagesPanel;

    private JLabel cancelLabel;
    private JLabel addPlayerLabel;
    private JComboBox pawnCombobox;
    private JLabel nameLabel;
    private JLabel pawnLabel;
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
    private JLabel startGameLabel;
    private JLabel maxplayerLabel;
    private JLabel imagepawnLabel;
    private JButton cancelButton;
    private Font font;
    private Utils utils;
    private PlayerHandler playerHandler;
    private BoxesHandler boxesHandler;


    public NewPlayerForm(NewPlayerFrame newPlayerFrame) {
        playerHandler = PlayerHandler.getInstance();
        boxesHandler = BoxesHandler.getInstance();
        utils = Utils.getInstance();

        try {
            setFontStartUP();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(
                    newPlayerFrame,
                    "Errore nello stato del caricamento del font",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        addPlayerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addPlayer();
            }
        });

        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newPlayerFrame.dispose();
            }
        });

        startGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                maxPlayers(newPlayerFrame);
            }
        });

    }

    private void addPlayer() {
        if (playerHandler.getNumPlayer() < 6) {
            try {
                playerHandler.addPlayer(nameTextFileld.getText(),String.valueOf(pawnCombobox.getSelectedItem()));
                int x = pawnCombobox.getSelectedIndex();
                pawnCombobox.removeItemAt(x);
                nameTextFileld.setText("");
            } catch (NullNameException ex) {
                JOptionPane.showMessageDialog(
                        newplayerForm,
                        "Errore nel nome campo non compilato",
                        "Errore",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(
                    newplayerForm,
                    "Numero di giocatori massimo raggiunto",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void maxPlayers(Frame newPlayerFrame){
        if (playerHandler.getNumPlayer() < 2) {
            JOptionPane.showMessageDialog(
                    null,
                    "Numero di giocatori troppo basso",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            playerHandler.setPlayerMoneyAndContracts();
            ScoreBoardForm scoreboardFrame = new ScoreBoardForm(boxesHandler,playerHandler);
            scoreboardFrame.setVisible(true);
            newPlayerFrame.dispose();
        }
    }

    private void setImageName(int x) {
        //TODO da fare setta il nome e immagine del player
    }

    public JPanel getPanel() {
        return newplayerForm;
    }

<<<<<<< Updated upstream
    private void setFontStartUP() {
        InputStream inputStream = MainFrameForm.class.getResourceAsStream("/it/monopoly/fonts/KabelBd-Normal.ttf");
=======
    private void setFontStartUP() throws FileNotFoundException {
        InputStream inputStream = MainFrameForm.class.getResourceAsStream("/it/monopoly/resources/fonts/KabelBd-Normal.ttf");

>>>>>>> Stashed changes
        try {
            assert inputStream != null;
            font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        imageLabelp1.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp2.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp3.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp4.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp5.setFont(font.deriveFont(Font.PLAIN, 36));
        imageLabelp6.setFont(font.deriveFont(Font.PLAIN, 36));
        cancelLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        addPlayerLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        startGameLabel.setFont(font.deriveFont(Font.PLAIN, 38));
        nameLabel.setFont(font.deriveFont(Font.PLAIN, 15));
        pawnLabel.setFont(font.deriveFont(Font.PLAIN, 15));

    }
}
