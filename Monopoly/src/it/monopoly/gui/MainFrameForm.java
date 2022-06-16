package it.monopoly.gui;

import it.monopoly.app.BoxesHandler;
import it.monopoly.app.GameHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainFrameForm {
    private JPanel menuPanel;
    private JLabel monopolyLabel;
    private JLabel playLabel;
    private JLabel continueGameLabel;
    private JLabel exitLabel;
    private Font font;
    private NewPlayerFrame newplayerFrame;
    private BoxesHandler boxesHandler;
    private PlayerHandler playerHandler;

    public MainFrameForm(MainFrame mainFrame) {
        setBoxesStrartUP(mainFrame);
        setFontStartUP();
        newplayerFrame = new NewPlayerFrame();

        playLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameHandler.getInstance().start();
                newplayerFrame.setVisible(true);
                mainFrame.dispose();
            }
        });

        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.dispose();
            }
        });


        continueGameLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ee) {
                try {
                    GameHandler.getInstance().loadGame();
                    ScoreBoardForm scoreBoardForm = new ScoreBoardForm();
                    scoreBoardForm.setVisible(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Errore nello stato del salvataggio del gioco",
                            "Salvataggio non trovato",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getPanel() {
        return this.menuPanel;
    }

    private void setFontStartUP() {
        InputStream inputStream = MainFrameForm.class.getResourceAsStream("/it/monopoly/resources/fonts/KabelBd-Normal.ttf");
        try {
            assert inputStream != null;
            font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        monopolyLabel.setFont(font.deriveFont(Font.PLAIN, 72));
        playLabel.setFont(font.deriveFont(Font.PLAIN, 36));
        continueGameLabel.setFont(font.deriveFont(Font.PLAIN, 36));
        exitLabel.setFont(font.deriveFont(Font.PLAIN, 36));
    }

    private void setBoxesStrartUP(MainFrame mainFrame) {
        try {
            GameHandler.getInstance().loadBoaxes();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(
                    mainFrame,
                    "Errore nello stato del caricamento delle caselle",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
