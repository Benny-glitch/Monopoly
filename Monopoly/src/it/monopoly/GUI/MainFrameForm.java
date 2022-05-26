package it.monopoly.GUI;

import it.monopoly.app.ContractsHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class MainFrameForm {
    private JPanel menuPanel;
    private JLabel monopolyLabel;
    private JLabel giocaLabel;
    private JLabel continuaLabel;
    private JLabel esciLabel;
    private Font font;
    private NewPlayerFrame newplayerFrame;
    private ContractsHandler contractsHandler;
    private PlayerHandler playerHandler;

    public MainFrameForm(MainFrame mainFrame) {
        setFontStartUP();
        contractsHandler = new ContractsHandler();
        newplayerFrame = new NewPlayerFrame();
        playerHandler = PlayerHandler.getInstance();
        giocaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newplayerFrame.setVisible(true);
                mainFrame.dispose();
            }
        });

        esciLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.dispose();
            }
        });


        continuaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ee) {
                try {
                    playerHandler = PlayerHandler.load();
                    contractsHandler = ContractsHandler.load();
                    ScoreBoardForm schermataGioco = new ScoreBoardForm(contractsHandler, playerHandler);
                    schermataGioco.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel() {
        return this.menuPanel;
    }

    private void setFontStartUP() {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/it/monopoly/fonts/KabelBd-Normal.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        monopolyLabel.setFont(font.deriveFont(Font.PLAIN, 72));
        giocaLabel.setFont(font.deriveFont(Font.PLAIN, 36));
        continuaLabel.setFont(font.deriveFont(Font.PLAIN, 36));
        esciLabel.setFont(font.deriveFont(Font.PLAIN, 36));
    }
}
