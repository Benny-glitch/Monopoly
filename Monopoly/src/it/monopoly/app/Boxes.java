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

    public Boxes(String name, int price, int rent, boolean beBought){
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.beBought = beBought;
    }

    public boolean isPurchased() {
        return this.purchased;
    }

    public void setPurchased() {
        this.purchased = true;
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

    public String toString(){
        return "nome Proprieta'= " + this.name + " Affitto= " + this.rent + "\n";
    }


}