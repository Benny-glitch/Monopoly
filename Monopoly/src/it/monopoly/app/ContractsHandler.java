package it.monopoly.app;

import java.util.List;
import java.util.ArrayList;

public class ContractsHandler {
    private List<Contract> contratti;

    public ContractsHandler() {
        this.contratti = new ArrayList<>(26);
        this.contratti.add(new Contract("Vicolo Corto", 60, 2));
        this.contratti.add(new Contract("Vicolo Stretto", 60, 4));
        this.contratti.add(new Contract("Bastioni Gran Sasso", 100, 6));
        this.contratti.add(new Contract("Viale Monterosa", 100, 6));
        this.contratti.add(new Contract("Viale Vesuvio", 120, 8));
        this.contratti.add(new Contract("Via Accademia", 140, 10));
        this.contratti.add(new Contract("Corso Ateneo", 140, 10));
        this.contratti.add(new Contract("Piazza Università", 160, 12));
        this.contratti.add(new Contract("Via Verdi", 180, 14));
        this.contratti.add(new Contract("Corso Raffaello", 180, 14));
        this.contratti.add(new Contract("Piazza Dante", 200, 16));
        this.contratti.add(new Contract("Via Marco Polo", 220, 18));
        this.contratti.add(new Contract("Corso Magellano", 220, 18));
        this.contratti.add(new Contract("Larco Colombo", 240, 20));
        this.contratti.add(new Contract("Viale Costantino", 260, 22));
        this.contratti.add(new Contract("Viale Traiano", 260, 22));
        this.contratti.add(new Contract("Piazza Giulio Cesare", 280, 24));
        this.contratti.add(new Contract("Via Roma", 300, 26));
        this.contratti.add(new Contract("Corso Impero", 300, 26));
        this.contratti.add(new Contract("Largo Augusto", 320, 28));
        this.contratti.add(new Contract("Viale dei Giardini", 350, 35));
        this.contratti.add(new Contract("Parco della Vittoria", 400, 40));
        this.contratti.add(new Contract("Stazione Sud", 200, 25));
        this.contratti.add(new Contract("Stazione Nord", 200, 25));
        this.contratti.add(new Contract("Stazione Est", 200, 25));
        this.contratti.add(new Contract("Stazione Ovest", 200, 25));
    }

    public Contract get(int num) {
        return contratti.get(num);
    }

    public String ContrattoLibero() {
        String contratti_liberi = null;
        for(int i = 0; i < contratti.size(); i++){
            if(!contratti.get(i).getAcquistato()){
              contratti_liberi += i +" Nome:" + contratti.get(i).getNome() + " Affitto: " + contratti.get(i).getAffitto() + " Prezzo: " + contratti.get(i).getPrezzo() + "\n";
            }
        }
        return contratti_liberi;
    }
}