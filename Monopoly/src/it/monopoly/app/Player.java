package it.monopoly.app;

import java.io.Serializable;
import java.util.*;

public class Player implements Serializable {
    //pedine
    public static final int MACCHINA             = 0;
    public static final int NAVE_DA_GUERRA       = 1;
    public static final int STIVALE              = 2;
    public static final int CILINDRO             = 3;
    public static final int DITALE               = 4;
    public static final int CAVALLO              = 5;

    private String username;
    private int money;
    private int position;
    private int shiftsinjail;
    private List<Contract> contracts = new ArrayList<>();
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
        return " Username =" + this.username + " Soldi=" + this.money + " TipodiPedina=" + this.typeofpawn + " Contratti=" + this.contracts;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setContracts(Contract contracts){
        this.contracts.add(contracts);
    }

    public String getContractListString(){
        String lista_contratti = null;
        for(int i = 0; i < contracts.size(); i++){
            lista_contratti += i +" Nome:" + contracts.get(i).getName() + " Affitto: " + contracts.get(i).getRent() + "\n";
        }
        return lista_contratti.replace("null", "");
    }
    public void pay(Player reciving, int moneytorecive){
        reciving.addMoney(moneytorecive);
        addMoney(-moneytorecive);
    }
    public Contract getContractList(int i){
        return contracts.get(i);
    }

    public String getContractListName(int i){
        return contracts.get(i).getName();
    }

    public int getNumContracts(){
        return contracts.size();
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
        return contracts.get(i).getRent();
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

    public Contract getContract(int i){
        return this.contracts.get(i);
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
