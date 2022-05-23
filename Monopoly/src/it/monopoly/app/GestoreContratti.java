package it.monopoly.app;

import java.util.List;
import java.util.ArrayList;

public class GestoreContratti {
    private List<Contratto> contratti;

    public GestoreContratti() {
        this.contratti = new ArrayList<>(26);
        this.contratti.add(new Contratto("Vicolo Corto", 60, 2));
        this.contratti.add(new Contratto("Vicolo Stretto", 60, 4));
        this.contratti.add(new Contratto("Bastioni Gran Sasso", 100, 6));
        this.contratti.add(new Contratto("Viale Monterosa", 100, 6));
        this.contratti.add(new Contratto("Viale Vesuvio", 120, 8));
        this.contratti.add(new Contratto("Via Accademia", 140, 10));
        this.contratti.add(new Contratto("Corso Ateneo", 140, 10));
        this.contratti.add(new Contratto("Piazza Università", 160, 12));
        this.contratti.add(new Contratto("Via Verdi", 180, 14));
        this.contratti.add(new Contratto("Corso Raffaello", 180, 14));
        this.contratti.add(new Contratto("Piazza Dante", 200, 16));
        this.contratti.add(new Contratto("Via Marco Polo", 220, 18));
        this.contratti.add(new Contratto("Corso Magellano", 220, 18));
        this.contratti.add(new Contratto("Larco Colombo", 240, 20));
        this.contratti.add(new Contratto("Viale Costantino", 260, 22));
        this.contratti.add(new Contratto("Viale Traiano", 260, 22));
        this.contratti.add(new Contratto("Piazza Giulio Cesare", 280, 24));
        this.contratti.add(new Contratto("Via Roma", 300, 26));
        this.contratti.add(new Contratto("Corso Impero", 300, 26));
        this.contratti.add(new Contratto("Largo Augusto", 320, 28));
        this.contratti.add(new Contratto("Viale dei Giardini", 350, 35));
        this.contratti.add(new Contratto("Parco della Vittoria", 400, 40));
        this.contratti.add(new Contratto("Stazione Sud", 200, 25));
        this.contratti.add(new Contratto("Stazione Nord", 200, 25));
        this.contratti.add(new Contratto("Stazione Est", 200, 25));
        this.contratti.add(new Contratto("Stazione Ovest", 200, 25));
    }

    public Contratto get(int num) {
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