package it.monopoly.app;

import java.util.List;
import java.util.ArrayList;

public class ContractsHandler {
    private List<Contract> contracts;

    public ContractsHandler() {
        this.contracts = new ArrayList<>(26);
        this.contracts.add(new Contract("Vicolo Corto", 60, 2));
        this.contracts.add(new Contract("Vicolo Stretto", 60, 4));
        this.contracts.add(new Contract("Bastioni Gran Sasso", 100, 6));
        this.contracts.add(new Contract("Viale Monterosa", 100, 6));
        this.contracts.add(new Contract("Viale Vesuvio", 120, 8));
        this.contracts.add(new Contract("Via Accademia", 140, 10));
        this.contracts.add(new Contract("Corso Ateneo", 140, 10));
        this.contracts.add(new Contract("Piazza Università", 160, 12));
        this.contracts.add(new Contract("Via Verdi", 180, 14));
        this.contracts.add(new Contract("Corso Raffaello", 180, 14));
        this.contracts.add(new Contract("Piazza Dante", 200, 16));
        this.contracts.add(new Contract("Via Marco Polo", 220, 18));
        this.contracts.add(new Contract("Corso Magellano", 220, 18));
        this.contracts.add(new Contract("Larco Colombo", 240, 20));
        this.contracts.add(new Contract("Viale Costantino", 260, 22));
        this.contracts.add(new Contract("Viale Traiano", 260, 22));
        this.contracts.add(new Contract("Piazza Giulio Cesare", 280, 24));
        this.contracts.add(new Contract("Via Roma", 300, 26));
        this.contracts.add(new Contract("Corso Impero", 300, 26));
        this.contracts.add(new Contract("Largo Augusto", 320, 28));
        this.contracts.add(new Contract("Viale dei Giardini", 350, 35));
        this.contracts.add(new Contract("Parco della Vittoria", 400, 40));
        this.contracts.add(new Contract("Stazione Sud", 200, 25));
        this.contracts.add(new Contract("Stazione Nord", 200, 25));
        this.contracts.add(new Contract("Stazione Est", 200, 25));
        this.contracts.add(new Contract("Stazione Ovest", 200, 25));
    }

    public Contract get(int num) {
        return contracts.get(num);
    }

    public String getFreeContracts() {
        String contratti_liberi = null;
        for(int i = 0; i < contracts.size(); i++){
            if(!contracts.get(i).getPurchased()){
              contratti_liberi += i +" Nome:" + contracts.get(i).getName() + " Affitto: " + contracts.get(i).getRent() + " Prezzo: " + contracts.get(i).getPrice() + "\n";
            }
        }
        return contratti_liberi;
    }
}