package it.monopoly.GUI;

import com.sun.tools.javac.Main;

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
    private Font font;
    private NewPlayerFrame newplayerFrame;

    public PrincipalInterfaceForm(){
        set_font_startUP();
        newplayerFrame = new NewPlayerFrame();
        giocaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                newplayerFrame.setVisible(true);

            }
        });


    }
    public JPanel getPanel(){
        return this.menuPanel;
    }

    private void set_font_startUP(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/it/monopoly/fonts/KabelBd-Normal.ttf"));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        monopolyLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,72));
        giocaLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        continuaLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
    }
}
