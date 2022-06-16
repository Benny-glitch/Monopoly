package it.monopoly.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoxesHandler implements Serializable {
    public static final long serialVersionUID = 1L;

    private static BoxesHandler instance;

    private List<Boxes> boxes;

    /**
     * Metodo che inizializza la classe attraverso il metodo load {@link BoxesHandler#load()} se esiste una classe già serializzata in precendeza.
     * @throws IOException se c'è un errore nel caricamento della classe serializzata in precedenza o se questa non esiste.
     */
    public static void initialize() throws IOException {
        BoxesHandler.instance = BoxesHandler.load();
    }

    /**
     * Metodo che restituisce l'istanza della classe se non è nulla altrimenti ne viene creata una nuova.
     * @return una istanza di Boxeshandler.
     */
    public static BoxesHandler getInstance() {
        if (instance == null) {
            instance = new BoxesHandler();
        }
        return instance;
    }

    private BoxesHandler(){
        this.boxes = new ArrayList<>(40);

    }

    /**
     * Metodo per il caricamento attraverso file .csv, presente nella directory files, di tutte le caselle presenti nell'ArrayList {@link BoxesHandler#boxes}.
     * Lancia un Exception se il file non viene trovato.
     * @throws Exception se c'è un errore nel caricamento dei valori del file nell' ArrayList oppure il file non esiste nel percorso specificato.
     */
    public void loadBoxes() throws FileNotFoundException {
        //TODO fare l'InputStream
        int rent, price;
        String name;
        boolean canBeBought, aTax;
        Scanner scanner = null;


        scanner = new Scanner(new File("Monopoly/src/it/monopoly/files/boxes.csv"));


        scanner.useDelimiter(",");

        while(scanner.hasNext()){
            name = scanner.next();
            price = scanner.nextInt();
            rent = scanner.nextInt();
            canBeBought = scanner.next().equals("true");
            aTax = scanner.next().equals("true");

            this.addBoxes(name.replace("\n", "").replace("\r",""), price, rent, canBeBought, aTax);

        }
        scanner.close();
    }

    public Boxes getContract(int num) {
        return boxes.get(num);
    }

    /**
     * @deprecated Metodo utilizzato per la versione CLI del Monopoly. Restiuisce una stringa di contratti liberi che un giocatore poteva acquistare.
     * @return stringa di contratti liberi.
     */
    public String getFreeContracts() {
        StringBuilder free_contracts = null;
        for(int i = 0; i < boxes.size(); i++){
            if(!boxes.get(i).getCanBeBought()){
              free_contracts.append(i).append(" Nome:").append(boxes.get(i).getName()).append(" Affitto: ").append(boxes.get(i).getRent()).append(" Prezzo: ").append(boxes.get(i).getPrice()).append("\n");
            }
        }
        assert free_contracts != null;
        return free_contracts.toString();
    }


    public void addBoxes(String name, int price, int rent, boolean canbebought,boolean aTax){
        Boxes contratto = new Boxes(name, price, rent, canbebought,aTax);
        this.boxes.add(contratto);
    }

    /**
     * Metodo che si occupa della Serializzazione e salvataggio dello stato del gioco richiamato ad ogni fine turno di ogni giocatore.
     * Genera un Exception se il file non viene generato correttamente o se la classe da salvare non viene passatra correttamente.
     * @throws IOException
     */
    //TODO fare il SAVEMANAGER
    public void saveState() throws IOException {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("Monopoly/src/it/monopoly/resources/Saves/Boxes.sr");
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
    public static BoxesHandler load() throws IOException {
        try (
                FileInputStream fileInputStream = new FileInputStream("Monopoly/src/it/monopoly/resources/Saves/Boxes.sr");
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


    public static BoxesHandler loadGame() throws IOException{
        if(instance == null){
            instance = load();
        }
        return instance;
    }

}