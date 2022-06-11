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

    public double getMoney() {
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

    public void pay(Player reciving, int moneytorecive) {
        reciving.addMoney(moneytorecive);
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

    public void buy(int moneyto) {
        this.money -= moneyto;
    }

    public void exitPrison() {
        this.shiftsInJail = 0;
        this.inJail = false;
    }

    public String getPawn() {
        return this.typeOfPawn;
    }

}
