package it.monopoly.app;

public class Contract {
    private String nome;
    private int prezzo;
    private int affitto;
    private Player proprietario;
    private int id;
    private boolean acquistato;

    public Contract(String nome, int prezzo, int affitto){
        this.nome = nome;
        this.prezzo = prezzo;
        this.affitto = affitto;
        this.acquistato = false;
    }

    public void setAcquistato() {
        this.acquistato = true;
    }

    public void setProprietario(Player player){
        this.proprietario = player;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPrezzo(){
        return this.prezzo;
    }

    public int getAffitto(){
        return this.affitto;
    }

    public Player getProprietario() {
        return this.proprietario;
    }

    public boolean getAcquistato() {
        return this.acquistato;
    }

    public String toString(){
        return "nome Proprieta'= " + this.nome + " Affitto= " + this.affitto + "\n";
    }

}