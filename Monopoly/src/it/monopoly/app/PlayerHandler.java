package it.monopoly.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerHandler implements Serializable{
    public static final long serialVersionUID = 1L;
    private static PlayerHandler instance;

    private ArrayList<Player> players ;
    private ContractsHandler contracts;
    private int moneytoremove;

    public static void initialize() throws IOException {
        PlayerHandler.instance = PlayerHandler.load();
    }

    public static PlayerHandler getInstance() {
        if(instance == null){
              instance = new PlayerHandler();
        }
        return PlayerHandler.instance;
    }

    private PlayerHandler(){
        players = new ArrayList<>(6);
        contracts = new ContractsHandler();
    }

    Random rand = new Random();

    public void addPlayer(String username, int typeofpawn) throws IOException, NullNameException {
        try{
            Player player = new Player(username, false, 0, typeofpawn, 0);
            players.add(player);
            this.savePlayer();
        } catch (NullNameException|IOException e) {
            throw e;
        }
    }

    private void savePlayer() throws IOException{
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("menu.sr");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(this);
        }
    }

    private static PlayerHandler load() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("menu.sr");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Object o = objectInputStream.readObject();
            return (PlayerHandler) o;
        } catch (FileNotFoundException e) {
            return new PlayerHandler();
        } catch (ClassNotFoundException ignore) {
            return null;
        }
    }

    public void setPlayer_Money_and_Contracts() {
        for (int i = 0; i < players.size(); i++) {
            if (players.size() == 2) {
                for (int j = 0; j < 7; j++) {
                    Contract contract = contracts.get(rand.nextInt(26));
                    if (!contract.getAcquistato()) {
                        players.get(i).setContracts(contract);
                        moneytoremove+=contract.getPrezzo();
                        contract.setAcquistato();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(8750 - moneytoremove);
            }
            if (players.size() == 3) {
                for (int j = 0; j < 6; j++) {
                    Contract contract = contracts.get(rand.nextInt(26));
                    if (!contract.getAcquistato()) {
                        players.get(i).setContracts(contract);
                        moneytoremove+=contract.getPrezzo();
                        contract.setAcquistato();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(7500 - moneytoremove);
            }
            if (players.size() == 4) {
                for (int j = 0; j < 5; j++) {
                    Contract contract = contracts.get(rand.nextInt(26));
                    if (!contract.getAcquistato()) {
                        players.get(i).setContracts(contract);
                        moneytoremove+=contract.getPrezzo();
                        contract.setAcquistato();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(6250 - moneytoremove);
            }
            if (players.size() == 5) {
                for (int j = 0; j < 4; j++) {
                    Contract contract = contracts.get(rand.nextInt(26));
                    if (!contract.getAcquistato()) {
                        players.get(i).setContracts(contract);
                        moneytoremove+=contract.getPrezzo();
                        contract.setAcquistato();
                    } else {
                        j--;
                    }
                }
                players.get(i).setMoney(5000 - moneytoremove);
            }
            if (players.size() == 6) {
                for (int j = 0; j < 3; j++) {
                    Contract contract = contracts.get(rand.nextInt(26));
                    if (!contract.getAcquistato()) {
                        players.get(i).setContracts(contract);
                        moneytoremove+=contract.getPrezzo();
                        contract.setAcquistato();
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

    public Player getPlayer(int i){
        return players.get(i);
    }

}
