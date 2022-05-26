package it.monopoly.app;

import java.io.Serializable;

public class Contract implements Serializable {
    public static final long serialVersionUID = 1L;

    private String name;
    private int price;
    private int rent;
    private Player owner;
    private int id;
    private boolean purchased;

    public Contract(String name, int price, int rent){
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.purchased = false;
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

    public boolean getPurchased() {
        return this.purchased;
    }

    public String toString(){
        return "nome Proprieta'= " + this.name + " Affitto= " + this.rent + "\n";
    }


}