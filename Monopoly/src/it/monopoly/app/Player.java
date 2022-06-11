package it.monopoly.app;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    public static final long serialVersionUID = 1L;
    //pedine
    public static final int CAR             = 0;
    public static final int BATTLE_SHIP       = 1;
    public static final int STIVALE              = 2;
    public static final int CILINDRO             = 3;
    public static final int DITALE               = 4;
    public static final int CAVALLO              = 5;

    private String username;
    private int money;
    private int position;
    private int shiftsinjail;
    private List<Boxes> boxes = new ArrayList<>();
    private boolean IsInJail;
    private String typeofpawn;


    public Player(String username, boolean IsInJail, int shiftsinjail, String typeofpawn, int position) throws NullNameException{
        if(username.isEmpty()){
            throw new NullNameException();
        }
        this.username = username;
        this.IsInJail = IsInJail;
        this.shiftsinjail = shiftsinjail; //turni in prigione
        this.typeofpawn = typeofpawn;
        this.position = position;
    }


    public double getMoney() {
        return this.money;
    }

    public boolean getIsInJail(){
        return this.IsInJail;
    }

    public String getUsername(){
        return this.username;
    }

    public String getTypeofpawn() {
        return this.typeofpawn;
    }

    public int getShiftsinjail(){
        return this.shiftsinjail;
    }

    public String toString(){
        return " Username =" + this.username + " Soldi=" + this.money + " TipodiPedina=" + this.typeofpawn + " Contratti=" + this.boxes;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setContracts(Boxes contracts){
        this.boxes.add(contracts);
    }

    public String getContractListString(){
        String lista_contratti = null;
        for(int i = 0; i < boxes.size(); i++){
            lista_contratti += i +" Nome:" + boxes.get(i).getName() + " Affitto: " + boxes.get(i).getRent() + "\n";
        }
        return lista_contratti.replace("null", "");
    }
    public void pay(Player reciving, int moneytorecive){
        reciving.addMoney(moneytorecive);
        addMoney(-moneytorecive);
    }
    public Boxes getContractList(int i){
        return boxes.get(i);
    }

    public String getContractListName(int i){
        return boxes.get(i).getName();
    }

    public int getNumContracts(){
        return boxes.size();
    }

    public void buyContracts(Boxes boxes){
        buy(boxes.getPrice());
        this.boxes.add(boxes);
    }
    public void addMoney(int money_toadd){
        this.money += money_toadd;
    }

    public void setIsInJail(boolean IsInJail){
        this.IsInJail = IsInJail;
    }

    public void setShiftsinjail(int shiftsinjail){
        this.shiftsinjail = shiftsinjail;
    }

    public int getRentContract(int i){
        return boxes.get(i).getRent();
    }

    public int getPosition(){
        return this.position;
    }

    public void changePosition(int roll){
        position+=roll;
        if(position > position% 39){
            this.addMoney(500);
            position = position % 39;
        }
    }

    public Boxes getContract(int i){
        return this.boxes.get(i);
    }

    public void buy(int moneyto){
        this.money -= moneyto;
    }

    public void exitPrison(){
        this.shiftsinjail = 0;
        this.IsInJail = false;
    }

    public String getPawn(){
        return this.typeofpawn;
    }

}
