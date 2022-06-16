package it.monopoly.app;

import java.io.Serializable;
import java.util.*;


public class Player implements Serializable {
    public static final long serialVersionUID = 1L;

    private String username;
    private int money;
    private int position;
    private int shiftsInJail;
    private List<Boxes> boxes = new ArrayList<>();
    private boolean inJail;
    private String typeOfPawn;

    public Player(String username, boolean inJail, int shiftsInJail, String typeOfPawn, int position) throws NullNameException {
        if (username == null || username.isBlank()) {
            throw new NullNameException();
        }
        this.username = username;
        this.inJail = inJail;
        this.shiftsInJail = shiftsInJail; //turni in prigione
        this.typeOfPawn = typeOfPawn;
        this.position = position;
    }

    public int getMoney() {
        return this.money;
    }

    public boolean isInJail() {
        return this.inJail;
    }

    public String getUsername() {
        return this.username;
    }

    public int getShiftsInJail() {
        return this.shiftsInJail;
    }

    /**
     * Override del metodo toString utilizzato nella versione precendete del videogioco.
     * @return una stringa composta dal nome della Proprietà e Affitto su cui il metodo viene chiamato.
     * @deprecated Metodo utilizzato per la versione CLI del Monopoly. Restiuisce una stringa riguradante: Username, Soldi, Tipo pedina e Contratti del giocatore.
     */
    public String toString() {
        return " Username =" + this.username + " Soldi=" + this.money + " TipodiPedina=" + this.typeOfPawn + " Contratti=" + this.boxes;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setContracts(Boxes contracts) {
        this.boxes.add(contracts);
    }

    public String getContractListString() {
        StringBuilder lista_contratti = null;
        for (int i = 0; i < boxes.size(); i++) {
            assert false;
            lista_contratti.append(i).append(" Nome:").append(boxes.get(i).getName()).append(" Affitto: ").append(boxes.get(i).getRent()).append("\n");
        }
        assert false;
        return lista_contratti.toString().replace("null", "");
    }


    /**
     * Prende come parametri il giocatore di tipo Player a cui si dovrà pagare una tassa o un' affitto e i soldi di tipo int da togliere al player.
     * @param player giocatore nel momento in cui viene chimato il metodo
     * @param moneytorecive soldi da togliere al giocatore
     */
    public void pay(Player player, int moneytorecive) {
        player.addMoney(moneytorecive);
        addMoney(-moneytorecive);
    }

    public Boxes getContractList(int i) {
        return boxes.get(i);
    }

    public String getContractListName(int i) {
        return boxes.get(i).getName();
    }

    public int getNumContracts() {
        return boxes.size();
    }

    public void buyContracts(Boxes boxes) {
        buy(boxes.getPrice());
        this.boxes.add(boxes);
    }

    public void addMoney(int money_toadd) {
        this.money += money_toadd;
    }

    public void setIsInJail(boolean IsInJail) {
        this.inJail = IsInJail;
    }

    public void setShiftsInJail(int shiftsInJail) {
        this.shiftsInJail = shiftsInJail;
    }

    public int getRentContract(int i) {
        return boxes.get(i).getRent();
    }

    public int getPosition() {
        return this.position;
    }

    /**
     * Prende in inuput il valore del dado e cambia la posizione, effettua un controllo se la posizione corrente e maggiore della posizone modulo quindi il giocatore ha superato il VIA
     * allora gli vengono aggiunti 500€
     * @param roll valore dei dadi calcolato con il metodo {@link Dice#roll()}
     */
    public void changePosition(int roll) {
        position += roll;
        if (position > position % 39) {
            this.addMoney(500);
            position = position % 39;
        }
    }

    public Boxes getContract(int i) {
        return this.boxes.get(i);
    }

    public List<Boxes> getContracts(){
        return boxes;
    }

    public void buy(int moneyToRemove) {
        this.money -= moneyToRemove;
    }

    public void exitPrison() {
        this.shiftsInJail = 0;
        this.inJail = false;
    }

    public String getPawn() {
        return this.typeOfPawn;
    }

}
