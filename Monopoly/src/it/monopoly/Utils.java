package it.monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Utils {
    private static Utils instance;
    private static Random random;

    public static final String ICON_PATH = "/it/monopoly/resources/pawns/";


    public static Utils getInstance() {
        if(instance == null){
            instance = new Utils();
        }
        return instance;
    }

    private Utils(){
        random = new Random();
    }

    public static Image getImage(String imagePath){
        Image image = null;
        InputStream inputStream;

        try{
            inputStream = Utils.class.getResourceAsStream(imagePath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try{
            assert inputStream != null;
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

    public static ImageIcon getIcon(String iconPath){
        ImageIcon icon = new ImageIcon();

        icon.setImage(getImage(iconPath));

        return icon;
    }

}
