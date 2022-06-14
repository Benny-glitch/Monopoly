package it.monopoly.gui;

import com.sun.tools.javac.Main;
import it.monopoly.app.BoxesHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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

    public MainFrameForm(MainFrame mainFrame){

        setFontStartUP();
        newplayerFrame = new NewPlayerFrame();

        playLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
                    PlayerHandler.initialize();
                    playerHandler = PlayerHandler.load();
                    boxesHandler = BoxesHandler.load();
                    ScoreBoardForm scoreBoardForm = new ScoreBoardForm(boxesHandler, playerHandler);
                    scoreBoardForm.setVisible(true);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Errore nello stato del salvataggio del gioco",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getPanel() {
        return this.menuPanel;
    }

    private void setFontStartUP() {
        InputStream inputStream = MainFrameForm.class.getResourceAsStream("/it/monopoly/fonts/KabelBd-Normal.ttf");
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
}
