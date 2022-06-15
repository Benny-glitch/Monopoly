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

    /**
     * Metodo che inizializza la classe attraverso il metodo load {@link PlayerHandler#load()} se esiste una classe già serializzata in precendeza.
     *
     * @throws IOException se c'è un errore nel caricamento della classe serializzata in precedenza o se questa non esiste.
     */
    public static void initialize() throws IOException {
        PlayerHandler.instance = PlayerHandler.load();
    }

    /**
     * Metodo che restituisce l'istanza della classe se non è nulla altrimenti ne viene creata una nuova.
     *
     * @return una istanza di PlayerHandler.
     */
    public static PlayerHandler getInstance() {
        if (instance == null) {
            instance = new PlayerHandler();
        }
        return PlayerHandler.instance;
    }

    private PlayerHandler() {
        players = new ArrayList<>(6);
        boxes = BoxesHandler.getInstance();
        random = new Random();
    }

    /**
     * Aggiunge un giocatore all' ArrayList di giocatori. Lancia una Exception se il parametro Name vine lasciato vuoto.
     *
     * @param username   nome del giocatore da registrare.
     * @param typeofpawn tipo della pedina scelta dal giocatore.
     * @throws NullNameException se il se il parametro Name vine lasciato vuoto.
     */
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

    public void removePlayer(int player) {
        players.remove(player);
    }

    public int getNumPlayer() {
        return this.players.size();
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    /**
     * Metodo che si occupa della Serializzazione e salvataggio dello stato del gioco richiamato ad ogni fine turno di ogni giocatore.
     * Genera un Exception se il file non viene generato correttamente o se la classe da salvare non viene passatra correttamente.
     *
     * @throws IOException
     */
    public void saveState() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Player.sr");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        }
    }

    /**
     * Metodo che si occupa del caricamento della classe serializzata. Lancia una Exception se non è stato possibile il caricamento della classe salvata nel
     * precorso specificato.
     * @return un'istanza del Boxeshandler se esistenete.
     * @throws IOException se non è stato possibile il caricamento della classe salvata nel precorso specificato.
     */
    public static PlayerHandler load() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("Player.sr");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object o = objectInputStream.readObject();
            return (PlayerHandler) o;
        } catch (IOException e) {
            throw new IOException();
        } catch (ClassNotFoundException ignore) {
            return new PlayerHandler();
        }
    }

}
