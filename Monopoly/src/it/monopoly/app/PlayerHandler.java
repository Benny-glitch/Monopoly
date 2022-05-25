package it.monopoly.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerHandler {
    private ArrayList<Player> players = new ArrayList<>(6);
    private ContractsHandler contracts = new ContractsHandler();
    private int moneytoremove;

    Random rand = new Random();

    public void addPlayer(String username, int typeofpawn) {
        Player player = new Player(username, false, 0, typeofpawn, 0);
        players.add(player);
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
