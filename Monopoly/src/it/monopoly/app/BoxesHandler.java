package it.monopoly.app;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class BoxesHandler implements Serializable {
    public static final long serialVersionUID = 1L;

    private List<Boxes> boxes;

    public BoxesHandler() {
        this.boxes = new ArrayList<>();
        addContratto("VIA", 0, 0);
        addContratto("Vicolo Corto", 60, 2);
        addContratto("Probabilità", 0, 0);
        addContratto("Vicolo Stretto", 60, 4);
        addContratto("Tassa Patrimoniale", 0, 200);
        addContratto("Stazione Sud", 200, 25);
        addContratto("Bastioni Gran Sasso", 100, 6);
        addContratto("Imprevisti", 0, 0);
        addContratto("Viale Monterosa", 100, 6);
        addContratto("Viale Vesuvio", 120, 8);
        addContratto("Prigione/Transito", 0, 0);
        addContratto("Via Accademia", 140, 10);
        addContratto("Società elettrica", 0, 0);
        addContratto("Corso Ateneo", 140, 10);
        addContratto("Piazza Università", 160, 12);
        addContratto("Stazione Ovest", 200, 25);
        addContratto("Via Verdi", 180, 14);
        addContratto("Probabilità", 0, 0);
        addContratto("Corso Raffaello", 180, 14);
        addContratto("Piazza Dante", 200, 16);
        addContratto("Parcheggio Gratuito", 0, 0);
        addContratto("Via Marco Polo", 220, 18);
        addContratto("Imprevisti", 0, 0);
        addContratto("Corso Magellano", 220, 18);
        addContratto("Largo Colombo", 240, 20);
        addContratto("Stazione Nord", 200, 25);
        addContratto("Viale Costantino", 260, 22);
        addContratto("Viale Traiano", 260, 22);
        addContratto("Fontane", 0, 0);
        addContratto("Piazza Giulio Cesare", 280, 24);
        addContratto("In prigione!", 0, 0);
        addContratto("Via Roma", 300, 26);
        addContratto("Corso Impero", 300, 26);
        addContratto("Probabilità", 0, 0);
        addContratto("Largo Augusto", 320, 28);
        addContratto("Stazione Est", 200, 25);
        addContratto("Imprevisti", 0, 0);
        addContratto("Viale dei Giardini", 350, 35);
        addContratto("Tassa di Lusso", 0, 100);
        addContratto("Parco della Vittoria", 400, 40);

        boxes.get(0).setPurchased();
        boxes.get(2).setPurchased();
        boxes.get(4).setPurchased();
        boxes.get(7).setPurchased();
        boxes.get(10).setPurchased();
        boxes.get(12).setPurchased();
        boxes.get(17).setPurchased();
        boxes.get(20).setPurchased();
        boxes.get(22).setPurchased();
        boxes.get(28).setPurchased();
        boxes.get(30).setPurchased();
        boxes.get(33).setPurchased();
        boxes.get(36).setPurchased();
        boxes.get(38).setPurchased();

        boxes.get(0).setOwner(null);
        boxes.get(2).setOwner(null);
        boxes.get(4).setOwner(null);
        boxes.get(7).setOwner(null);
        boxes.get(10).setOwner(null);
        boxes.get(12).setOwner(null);
        boxes.get(17).setOwner(null);
        boxes.get(20).setOwner(null);
        boxes.get(22).setOwner(null);
        boxes.get(28).setOwner(null);
        boxes.get(30).setOwner(null);
        boxes.get(33).setOwner(null);
        boxes.get(36).setOwner(null);
        boxes.get(38).setOwner(null);
    }

    public Boxes get(int num) {
        return boxes.get(num);
    }

    public String getFreeContracts() {
        String contracts_liberi = null;
        for(int i = 0; i < boxes.size(); i++){
            if(!boxes.get(i).getPurchased()){
              contracts_liberi += i +" Nome:" + boxes.get(i).getName() + " Affitto: " + boxes.get(i).getRent() + " Prezzo: " + boxes.get(i).getPrice() + "\n";
            }
        }
        return contracts_liberi;
    }

    public void addContratto(String name, int price, int rent){
        Boxes contratto = new Boxes(name, price, rent);
        this.boxes.add(contratto);
    }

    public void salvaStato() throws IOException {
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