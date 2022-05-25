package it.monopoly;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Utils {
    private static List<ImageIcon> icons;
    private static Utils instance;

    public static Utils getInstance() {
        if(instance == null){
            instance = new Utils();
        }
        return instance;
    }

    private Utils(){
        icons = new ArrayList<>(6);
        load_icon();
    }

    public ImageIcon getIcons(int j) {
        return icons.get(j);
    }

    private static void load_icon()  {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("/Users/benedettotesta/Documents/GitHub/Monopoly/Monopoly/src/it/monopoly/resizedPedine/car.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        icons.add(new ImageIcon(bufferedImage));
        icons.add(new ImageIcon("it/monopoly/resizedPedine/war_ship.png"));
        icons.add(new ImageIcon("it/monopoly/resizedPedine/boot.png"));
        icons.add(new ImageIcon("it/monopoly/resizedPedine/top_hat.png"));
        icons.add(new ImageIcon("it/monopoly/resizedPedine/thimble.png"));
        icons.add(new ImageIcon("it/monopoly/resizedPedine/dog.png"));
    }

}
