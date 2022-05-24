package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NewPlayerForm extends JFrame{

    private JPanel newplayerForm;
    private JPanel playerimagesPanel;
    private JLabel playerLabel6;
    private JLabel playerLabel2;
    private JLabel playerLabel3;
    private JLabel playerLabel4;
    private JLabel playerLabel5;
    private JLabel playerLabel1;
    private JTextField textField1;
    private JLabel annullaLabel;
    private JLabel inserisciLabel;
    private JComboBox pedinaCombobox;
    private JButton annullaButton;
    private Font font;

    public NewPlayerForm(NewPlayerFrame newPlayerFrame){
        String[] Pedina = {"carriola", "gatto", "macchina", "cavallo", "scarpa", "ditale", "nave"};
        
        set_font_startUP();
    }

    public JPanel getPanel(){
        return newplayerForm;
    }



    private void set_font_startUP(){
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/it/monopoly/fonts/KabelBd-Normal.ttf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        playerLabel1.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        playerLabel2.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        playerLabel3.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        playerLabel4.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        playerLabel5.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        playerLabel6.setFont(font.deriveFont(Font.TRUETYPE_FONT,36));
        annullaLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,40));
        inserisciLabel.setFont(font.deriveFont(Font.TRUETYPE_FONT,40));
    }
}
