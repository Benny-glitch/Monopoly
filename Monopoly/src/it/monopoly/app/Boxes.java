package it.monopoly.app;

import java.io.Serializable;

public class Boxes implements Serializable {
    public static final long serialVersionUID = 1L;

    private String name;
    private int price;
    private int rent;
    private Player owner;
    private boolean purchased;
    private boolean beBought;
    private boolean aTax;

    public Boxes(String name, int price, int rent, boolean beBought, boolean aTax){
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.beBought = beBought;
        this.aTax = aTax;
    }

    /**
     * Restituisce un valore booleano per la casella su cui questo metodo viene chiamato.
     * @return true se la casella è già acquistata false il contrario.
     */
    public boolean isPurchased() {
        return this.purchased;
    }

    public void setPurchased() {
        this.purchased = true;
    }

    /**
     * Restuisce un valore booleano per la casella su cui il metodo viene chiamato.
     *
     * @return true la casella in questione e un casella di tipo Tassa false il contrario.
     */
    public boolean isATax(){
        return this.aTax;
    }

    public void setOwner(Player player){
        this.owner = player;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getRent(){
        return this.rent;
    }

    public Player getOwner() {
        return this.owner;
    }

    public boolean getCanBeBought() {
        return this.beBought;
    }

    /**
     * Override del metodo toString utilizzato nella versione precendete del videogioco.
     * @return una stringa composta dal nome della Proprietà e Affitto su cui il metodo viene chiamato.
     */
    public String toString(){
        return "nome Proprieta'= " + this.name + " Affitto= " + this.rent + "\n";
    }


}