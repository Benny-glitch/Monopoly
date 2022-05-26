package it.monopoly.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerHandler implements Serializable {
    public static final long serialVersionUID = 1L;

    private static PlayerHandler instance;

    private ArrayList<Player> players;
    private BoxesHandler contracts;
    private int moneytoremove;
    private Random rand;

    //TODO caricamento con il pulsante CONTINUA
    public static void initialize() throws IOException {
        PlayerHandler.instance = PlayerHandler.load();
    }

    public static PlayerHandler getInstance() {
        if (instance == null) {
            instance = new PlayerHandler();
        }
        return PlayerHandler.instance;
    }

    private PlayerHandler() {
        players = new ArrayList<>(6);
        contracts = new BoxesHandler();
        rand = new Random();
    }


    public void addPlayer(String username, String typeofpawn) throws NullNameException {
        try {
            Player player = new Player(username, false, 0, typeofpawn, 0);
            players.add(player);
        } catch (NullNameException e) {
            throw e;
        }
    }

    public void setPlayerMoneyandContracts() {
        for (int i = 0; i < players.size(); i++) {
            if (players.size() == 2) {
                for (int j = 0; j < 7; j++) {
                    Boxes boxes = contracts.get(rand.nextInt(26));
                    if (!boxes.getPurchased()) {
                        players.get(i).setContracts(boxes);
                        moneytoremove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(8750 - moneytoremove);
            }
            if (players.size() == 3) {
                for (int j = 0; j < 6; j++) {
                    Boxes boxes = contracts.get(rand.nextInt(26));
                    if (!boxes.getPurchased()) {
                        players.get(i).setContracts(boxes);
                        moneytoremove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(7500 - moneytoremove);
            }
            if (players.size() == 4) {
                for (int j = 0; j < 5; j++) {
                    Boxes boxes = contracts.get(rand.nextInt(26));
                    if (!boxes.getPurchased()) {
                        players.get(i).setContracts(boxes);
                        moneytoremove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(6250 - moneytoremove);
            }
            if (players.size() == 5) {
                for (int j = 0; j < 4; j++) {
                    Boxes boxes = contracts.get(rand.nextInt(26));
                    if (!boxes.getPurchased()) {
                        players.get(i).setContracts(boxes);
                        moneytoremove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(5000 - moneytoremove);
            }
            if (players.size() == 6) {
                for (int j = 0; j < 3; j++) {
                    Boxes boxes = contracts.get(rand.nextInt(26));
                    if (!boxes.getPurchased()) {
                        players.get(i).setContracts(boxes);
                        moneytoremove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(3750 - moneytoremove);
            }
        }
        Collections.shuffle(players);

        //schermataTurno.SchermataTurno(giocatori,contratti);
    }

    public int getNumPlayer() {
        return this.players.size();
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public void salvaStato() throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("Giocatori.sr");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        }
    }

    public static PlayerHandler load() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("Giocatori.sr");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            return (PlayerHandler) o;
        } catch (FileNotFoundException e) {
            return null;
        } catch (ClassNotFoundException ignore) {
            return new PlayerHandler();
        }
    }

}
