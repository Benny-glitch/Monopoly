package it.monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

public class Utils {
    private static List<ImageIcon> icons;
    private static Utils instance;
    private static Random random;

    public static final String ICON_PATH = "/it/monopoly/images/pawns/";

    public static Utils getInstance() {
        if(instance == null){
            instance = new Utils();
        }
        return instance;
    }

    private Utils(){
        icons = new ArrayList<>(6);
        random = new Random();
    }

    public ImageIcon getIcons(int j) throws IndexOutOfBoundsException{
        if(j > 6){
            throw new IndexOutOfBoundsException();
        }
        return icons.get(j);
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
