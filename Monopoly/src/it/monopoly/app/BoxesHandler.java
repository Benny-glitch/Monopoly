package it.monopoly.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoxesHandler implements Serializable {
    public static final long serialVersionUID = 1L;

    private List<Boxes> boxes;

    public BoxesHandler(){
        this.boxes = new ArrayList<>(40);
        loadBoxes();
    }
    
    private void loadBoxes() {
        int rent, price;
        String name;
        boolean canBeBought;
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("src/it/monopoly/files/boxes.csv"));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }

        scanner.useDelimiter(",");

        while(scanner.hasNext()){
            name = scanner.next();
            price = scanner.nextInt();
            rent = scanner.nextInt();
            canBeBought = scanner.next().equals("true");
            try {
                this.addContracts(name.replace("\n", ""), price, rent, canBeBought);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    public Boxes get(int num) {
        return boxes.get(num);
    }

    public String getFreeContracts() {
        String free_contracts = null;
        for(int i = 0; i < boxes.size(); i++){
            if(!boxes.get(i).getCanBeBought()){
              free_contracts += i +" Nome:" + boxes.get(i).getName() + " Affitto: " + boxes.get(i).getRent() + " Prezzo: " + boxes.get(i).getPrice() + "\n";
            }
        }
        return free_contracts;
    }

    public void addContracts(String name, int price, int rent, boolean canbebought){
        Boxes contratto = new Boxes(name, price, rent, canbebought);
        this.boxes.add(contratto);
    }

    public void saveState() throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("Boxes.sr");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        }
    }

    public static BoxesHandler load() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("Boxes.sr");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            return (BoxesHandler) o;
        } catch (FileNotFoundException e) {
            return null;
        } catch (ClassNotFoundException ignore) {
            return new BoxesHandler();
        }
    }

}