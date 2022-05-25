package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    public MainFrame(){
        super("Monopoly");
        setDeafultConfiguration();
        PrincipalInterfaceForm Form = new PrincipalInterfaceForm(this);
        setContentPane(Form.getPanel());

    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(DEFAULT_DIMENSION);
        this.setMinimumSize(DEFAULT_DIMENSION);
    }


}
