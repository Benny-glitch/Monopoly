package it.monopoly.app;

public class Turn {
    private int nplayer;
    private int count;

    public Turn(PlayerHandler players){
        nplayer = players.getNumPlayer() - 1;
         count = 0;
    }

    public int Turns(){
        if(count  == nplayer)
            count  = 0;
        else
            count ++;
        return count ;
    }
}
