package it.monopoly.app;
//
public class Turno {
    private int n;
    private PlayerHandler playerHandler;
    private int i;

    public Turno(PlayerHandler giocatori){
        n = giocatori.getNumPlayer() - 1;
        i = 0;
    }

    public int Turni(){
        if(i == n)
            i = 0;
        else
            i++;
        return i;
    }
}
