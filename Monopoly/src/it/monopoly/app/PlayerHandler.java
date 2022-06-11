package it.monopoly.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerHandler implements Serializable {
    public static final long serialVersionUID = 1L;
    private static PlayerHandler instance;

    private static final int TWO_PLAYER = 2;
    private static final int THREE_PLAYER = 3;
    private static final int FOUR_PLAYER = 4;
    private static final int FIVE_PLAYER = 5;
    private static final int SIX_PLAYER = 6;

    private static final int NUM_CONTRACTS = 26;

    private static final int CONTRATCTS_TWO_PLAYER = 7;
    private static final int CONTRATCTS_THREE_PLAYER = 6;
    private static final int CONTRATCTS_FOUR_PLAYER = 5;
    private static final int CONTRATCTS_FIVE_PLAYER = 4;
    private static final int CONTRATCTS_SIX_PLAYER = 3;

    private static final int MONEY_TWO_PLAYER = 8750;
    private static final int MONEY_THREE_PLAYER = 7500;
    private static final int MONEY_FOUR_PLAYER = 6250;
    private static final int MONEY_FIVE_PLAYER = 5000;
    private static final int MONEY_SIX_PLAYER = 3750;


    private ArrayList<Player> players;
    private BoxesHandler boxes;
    private int moneyToRemove;
    private Random random;


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
        boxes = new BoxesHandler();
        random = new Random();
    }

    public void addPlayer(String username, String typeofpawn) throws NullNameException {
        try {
            Player player = new Player(username, false, 0, typeofpawn, 0);
            players.add(player);
        } catch (NullNameException e) {
            throw e;
        }
    }

    public void setPlayerMoneyAndContracts() {
        for (int i = 0; i < players.size(); i++) {
            if (players.size() == TWO_PLAYER) {
                for (int j = 0; j < CONTRATCTS_TWO_PLAYER; j++) {
                    Boxes boxes = this.boxes.get(random.nextInt(NUM_CONTRACTS));
                    if (boxes.getCanBeBought()) {
                        players.get(i).setContracts(boxes);
                        moneyToRemove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(MONEY_TWO_PLAYER - moneyToRemove);
            }
            if (players.size() == THREE_PLAYER) {
                for (int j = 0; j < CONTRATCTS_THREE_PLAYER; j++) {
                    Boxes boxes = this.boxes.get(random.nextInt(NUM_CONTRACTS));
                    if (boxes.getCanBeBought()) {
                        players.get(i).setContracts(boxes);
                        moneyToRemove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(MONEY_THREE_PLAYER - moneyToRemove);
            }
            if (players.size() == FOUR_PLAYER) {
                for (int j = 0; j < CONTRATCTS_FOUR_PLAYER; j++) {
                    Boxes boxes = this.boxes.get(random.nextInt(NUM_CONTRACTS));
                    if (boxes.getCanBeBought()) {
                        players.get(i).setContracts(boxes);
                        moneyToRemove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(MONEY_FOUR_PLAYER - moneyToRemove);
            }
            if (players.size() == FIVE_PLAYER) {
                for (int j = 0; j < CONTRATCTS_FIVE_PLAYER; j++) {
                    Boxes boxes = this.boxes.get(random.nextInt(NUM_CONTRACTS));
                    if (boxes.getCanBeBought()) {
                        players.get(i).setContracts(boxes);
                        moneyToRemove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(MONEY_FIVE_PLAYER - moneyToRemove);
            }
            if (players.size() == SIX_PLAYER) {
                for (int j = 0; j < CONTRATCTS_SIX_PLAYER; j++) {
                    Boxes boxes = this.boxes.get(random.nextInt(NUM_CONTRACTS));
                    if (boxes.getCanBeBought()) {
                        players.get(i).setContracts(boxes);
                        moneyToRemove += boxes.getPrice();
                        boxes.setPurchased();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(MONEY_SIX_PLAYER - moneyToRemove);
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

    public void saveState() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Giocatori.sr"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        }
    }

    public static PlayerHandler load() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("Giocatori.sr"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object o = objectInputStream.readObject();
            return (PlayerHandler) o;
        } catch (FileNotFoundException e) {
            return null;
        } catch (ClassNotFoundException ignore) {
            return new PlayerHandler();
        }
    }

}
