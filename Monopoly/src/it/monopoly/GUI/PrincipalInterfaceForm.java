package it.monopoly.GUI;

import com.sun.tools.javac.Main;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class PrincipalInterfaceForm {
    private JPanel menuPanel;
    private JLabel monopolyLabel;
    private JLabel giocaLabel;
    private JLabel continuaLabel;
    private JLabel esciLabel;
    private Font font;
    private NewPlayerFrame newplayerFrame;

    public PrincipalInterfaceForm(MainFrame mainFrame){
        setFontStartUP();
        newplayerFrame = new NewPlayerFrame();
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

        //TODO continua Label per il salvataggio dello stato
        /*continuaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    PlayerHandler.initialize();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Non è stato possibile caricare la partita: " + ex.getMessage(),
                            "Errore apertura file",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });*/
    }
    public JPanel getPanel(){
        return this.menuPanel;
    }

    private void setFontStartUP(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Monopoly/src/it/monopoly/fonts/KabelBd-Normal.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        monopolyLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,72));
        giocaLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        continuaLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        esciLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
    }
}
