package it.monopoly.GUI;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super();
        PrincipalInterfaceForm Form = new PrincipalInterfaceForm();
        setTitle("Monopoly");
        setContentPane(Form.getPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
    }



}
