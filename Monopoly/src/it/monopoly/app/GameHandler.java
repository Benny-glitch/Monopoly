package it.monopoly.app;

import java.io.IOException;

public class GameHandler {

    public static GameHandler instance;
    private int turn;
    private int doubleRoll;


    private GameHandler(){
        this.turn = 0;
    }

    public static GameHandler getInstance(){
        if(instance == null){
            instance = new GameHandler();
        }
        return instance;
    }
    
    public void start(){
        BoxesHandler.getInstance();
        PlayerHandler.getInstance();
    }
    
    public void loadGame() throws IOException {
        BoxesHandler.loadGame();
        PlayerHandler.loadGame();
    }

    public boolean payRentCheck(){
        int position = PlayerHandler.getInstance().getPlayer(this.turn).getPosition();
        if (BoxesHandler.getInstance().getContract(position).isPurchased() &&
                BoxesHandler.getInstance().getContract(position).getOwner() != null){
            if(BoxesHandler.getInstance().getContract(position).getOwner() != PlayerHandler.getInstance().getPlayer(this.turn))
            return true;
        }
        return false;
    }
    
    public void payRent(){
        int position = PlayerHandler.getInstance().getPlayer(this.turn).getPosition();
        Player owner = BoxesHandler.getInstance().getContract(position).getOwner();
        PlayerHandler.getInstance().getPlayer(this.turn).pay(owner, BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition()).getRent());
    }

    /**
     * Incrementa l'indice del turno al turno successivo
     * @return Restituisce un intero che rappresenta il nuovo turno
     */
    public int turn() {
        if (this.turn == PlayerHandler.getInstance().getNumPlayer()-1) {
            this.turn = 0;
            this.doubleRoll = 0;
        }
        else {
            this.turn++;
            this.doubleRoll = 0;
        }
        return this.turn;
    }

    public int getTurn(){
        return this.turn;
    }


    public String getPlayerUsername() {
        return PlayerHandler.getInstance().getPlayer(turn).getUsername();
    }

    public int getPlayerMoney() {
        return PlayerHandler.getInstance().getPlayer(turn).getMoney();
    }

    public void saveState() throws IOException {
        PlayerHandler.getInstance().saveState();
        BoxesHandler.getInstance().saveState();
    }


}
