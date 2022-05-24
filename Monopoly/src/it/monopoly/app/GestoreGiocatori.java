package it.monopoly.app;

import it.monopoly.ui.SchermataTurno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GestoreGiocatori {
    private ArrayList<Giocatore> giocatori = new ArrayList<>(6);
    private GestoreContratti contratti = new GestoreContratti();
    private SchermataTurno schermataTurno = new SchermataTurno();

    Random rand = new Random();

    public void addGiocatore(String username, int typeofpawn) {
        Giocatore giocatore = new Giocatore(username, false, 0, typeofpawn);
        giocatori.add(giocatore);
    }

    public void setGiocatoreSoldiEcontratti() {
        for (int i = 0; i < giocatori.size(); i++) {
            if (giocatori.size() == 2) {
                giocatori.get(i).setMoney(8750);
                for (int j = 0; j < 7; j++) {
                    Contratto contratto = contratti.get(rand.nextInt(26));
                    if (!contratto.getAcquistato()) {
                        giocatori.get(i).setContracts(contratto);
                        contratto.setAcquistato();
                    } else {
                        j--;
                    }
                }
            }
            if (giocatori.size() == 3) {
                giocatori.get(i).setMoney(7500);
                for (int j = 0; j < 6; j++) {
                    Contratto contratto = contratti.get(rand.nextInt(26));
                    if (!contratto.getAcquistato()) {
                        giocatori.get(i).setContracts(contratto);
                        contratto.setAcquistato();
                    } else {
                        j--;
                    }
                }
            }
            if (giocatori.size() == 4) {
                giocatori.get(i).setMoney(6250);
                for (int j = 0; j < 5; j++) {
                    Contratto contratto = contratti.get(rand.nextInt(26));
                    if (!contratto.getAcquistato()) {
                        giocatori.get(i).setContracts(contratto);
                        contratto.setAcquistato();
                    } else {
                        j--;
                    }
                }
            }
            if (giocatori.size() == 5) {
                giocatori.get(i).setMoney(5000);
                for (int j = 0; j < 4; j++) {
                    Contratto contratto = contratti.get(rand.nextInt(26));
                    if (!contratto.getAcquistato()) {
                        giocatori.get(i).setContracts(contratto);
                        contratto.setAcquistato();
                    } else {
                        j--;
                    }
                }
            }
            if (giocatori.size() == 6) {
                giocatori.get(i).setMoney(3750);
                for (int j = 0; j < 3; j++) {
                    Contratto contratto = contratti.get(rand.nextInt(26));
                    if (!contratto.getAcquistato()) {
                        giocatori.get(i).setContracts(contratto);
                        contratto.setAcquistato();
                    } else {
                        j--;
                    }
                }
            }
        }
        Collections.shuffle(giocatori);

        //schermataTurno.SchermataTurno(giocatori,contratti);
    }

    public int getNumgiocatori() {
        return this.giocatori.size();
    }

    public Giocatore getGiocatore(int i){
        return giocatori.get(i);
    }

}
