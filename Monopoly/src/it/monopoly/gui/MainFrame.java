package it.monopoly.gui;

import it.monopoly.app.BoxesHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame {

    public static final Dimension DEFAULT_DIMENSION = new Dimension(800, 600);
    ImageIcon imgIcon = new ImageIcon("src/it/monopoly/pawns/easter-egg.png");
    public MainFrame(){
        super("Monopoly");
        setDeafultConfiguration();
        MainFrameForm Form = new MainFrameForm(this);
        setContentPane(Form.getPanel());
    }

    private void setDeafultConfiguration() {
        this.setIconImage(imgIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }
}
