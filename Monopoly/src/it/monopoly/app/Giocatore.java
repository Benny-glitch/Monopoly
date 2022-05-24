package it.monopoly.app;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Giocatore {
    //pedine
    public static final int CARRIOLA             = 0;
    public static final int NAVE_DA_GUERRA       = 1;
    public static final int SACCO_DI_SOLDI       = 2;
    public static final int CAVALLO_E_CAVALIERE  = 3;
    public static final int MACCHINA             = 4;
    public static final int TRENO                = 5;
    public static final int DITALE               = 6;
    public static final int CANNONE              = 7;
    public static final int STIVALE              = 8;

    private String username;
    private int money;
    private int shiftsinjail;
    private List<Contratto> contracts = new ArrayList<>();
    private boolean isinjail;
    private int typeofpawn;


    public Giocatore(String username, boolean isinjail, int shiftsinjail, int typeofpawn){
        this.username = username;
        this.isinjail = isinjail;
        this.shiftsinjail = shiftsinjail; //turni in prigione
        this.typeofpawn = typeofpawn;
    }

    public double getMoney() {
        return this.money;
    }

    public boolean getIsinjail(){
        return this.isinjail;
    }

    public String getUsername(){
        return this.username;
    }

    public int getTypeofpawn() {
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

    public void setContracts(Contratto contracts){
        this.contracts.add(contracts);
    }

    public String getListaContratti(){
        String lista_contratti = null;
        for(int i = 0; i < contracts.size(); i++){
            lista_contratti += i +" Nome:" + contracts.get(i).getNome() + " Affitto: " + contracts.get(i).getAffitto() + "\n";
        }
        return lista_contratti.replace("null", "");
    }

    public void addMoney(int money_toadd){
        this.money += money_toadd;
    }

    public void setIsinjail(boolean isinjail){
        this.isinjail = isinjail;
    }

    public void setShiftsinjail(int shiftsinjail){
        this.shiftsinjail = shiftsinjail;
    }

    public int getAffittocontratto(int i){
        return contracts.get(i).getAffitto();
    }
}
