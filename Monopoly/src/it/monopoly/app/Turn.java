package it.monopoly.app;

import javax.swing.*;

public class Turn {
    private int nplayer;
    private int count;
    private Timer timer;
    private int second = 0;

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
