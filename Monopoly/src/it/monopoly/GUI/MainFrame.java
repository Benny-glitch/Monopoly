package it.monopoly.GUI;

import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    public MainFrame(){
        super("Monopoly");

        try {
            PlayerHandler.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDeafultConfiguration();
        MainFrameForm Form = new MainFrameForm(this);
        setContentPane(Form.getPanel());
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }


}
