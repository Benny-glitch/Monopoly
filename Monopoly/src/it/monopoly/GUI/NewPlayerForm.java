package it.monopoly.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import it.monopoly.app.GestoreGiocatori;

public class NewPlayerForm extends JFrame{

    private JPanel newplayerForm;
    private JPanel playerimagesPanel;

    private JLabel annullaLabel;
    private JLabel inserisciLabel;
    private JComboBox pedinaCombobox;
    private JLabel nomeLabel;
    private JLabel pedinaLabel;
    private JLabel imageLabelp1;
    private JLabel imageLabelp2;
    private JLabel imageLabelp3;
    private JLabel imageLabelp4;
    private JLabel imageLabelp5;
    private JLabel imageLabelp6;
    private JLabel nameLabelp1;
    private JLabel nameLabelp2;
    private JLabel nameLabelp3;
    private JLabel nameLabelp4;
    private JLabel nameLabelp5;
    private JLabel nameLabelp6;
    private JTextField nameTextFileld;
    private JLabel avviagiocoLabel;
    private JLabel maxplayerLabel;
    private JButton annullaButton;
    private Font font;

    public NewPlayerForm(NewPlayerFrame newPlayerFrame){
        GestoreGiocatori gestoreGiocatori = new GestoreGiocatori();

        set_font_startUP();

            inserisciLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(gestoreGiocatori.getNumgiocatori() <= 6){
                        gestoreGiocatori.addGiocatore(nameTextFileld.getText(), pedinaCombobox.getSelectedIndex());
                        int x = pedinaCombobox.getSelectedIndex();
                        pedinaCombobox.removeItemAt(x);
                        nameTextFileld.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Numero di giocatori massimo raggiunto","Errore" ,JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        annullaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 newPlayerFrame.dispose();
            }
        });

        avviagiocoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(gestoreGiocatori.getNumgiocatori() < 2){
                    JOptionPane.showMessageDialog(null, "Numero di giocatori troppo basso","Errore" ,JOptionPane.ERROR_MESSAGE);
                }else{
                    PlayerFrame playerFrame = new PlayerFrame(gestoreGiocatori);
                    TabelloneFrame tabelloneFrame = new TabelloneFrame();
                    playerFrame.setVisible(true);
                    newPlayerFrame.dispose();
                }
            }
        });
    }

    private void set_Image_Name(int x){
        //TODO da fare setta il nome e immagine del player
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
        imageLabelp1.setFont(font.deriveFont(Font.PLAIN,36));
        imageLabelp2.setFont(font.deriveFont(Font.PLAIN,36));
        imageLabelp3.setFont(font.deriveFont(Font.PLAIN,36));
        imageLabelp4.setFont(font.deriveFont(Font.PLAIN,36));
        imageLabelp5.setFont(font.deriveFont(Font.PLAIN,36));
        imageLabelp6.setFont(font.deriveFont(Font.PLAIN,36));
        annullaLabel.setFont(font.deriveFont(Font.PLAIN,38));
        inserisciLabel.setFont(font.deriveFont(Font.PLAIN,38));
        avviagiocoLabel.setFont(font.deriveFont(Font.PLAIN,38));
        nomeLabel.setFont(font.deriveFont(Font.PLAIN,15));
        pedinaLabel.setFont(font.deriveFont(Font.PLAIN,15));

    }
}
