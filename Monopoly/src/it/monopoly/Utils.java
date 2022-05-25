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
    private static Random random;

    public static Utils getInstance() {
        if(instance == null){
            instance = new Utils();
        }
        return instance;
    }

    private Utils(){
        icons = new ArrayList<>(6);
        random = new Random();
        load_icon();
    }

    public ImageIcon getIcons(int j) throws IndexOutOfBoundsException{
        if(j > 6){
            throw new IndexOutOfBoundsException();
        }
        return icons.get(j);
    }

    private static void load_icon()  {
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/car.png"));
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/war_ship.png"));
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/boot.png"));
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/top_hat.png"));
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/thimble.png"));
        icons.add(new ImageIcon("src/it/monopoly/resizedPedine/dog.png"));
    }

    public void get_dice(){

    }



}
