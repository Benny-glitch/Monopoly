package it.monopoly.app;

import java.io.FileNotFoundException;
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

    public int getRent(){
        return BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition()).getRent();
    }

    public int getPosition(){
        return PlayerHandler.getInstance().getPlayer(this.turn).getPosition();
    }

    public int getShiftInJail(){
        return PlayerHandler.getInstance().getPlayer(this.turn).getShiftsInJail();
    }

    public void moneyToRemoveJail(){
        PlayerHandler.getInstance().getPlayer(this.turn).buy(125);
    }

    public void exitPrison(){
        PlayerHandler.getInstance().getPlayer(this.turn).exitPrison();
    }

    public boolean isInJail(){
        return PlayerHandler.getInstance().getPlayer(this.turn).isInJail();
    }

    public void setIsInJail(){
        PlayerHandler.getInstance().getPlayer(this.turn).setIsInJail(true);
    }

    public void loadBoaxes() throws FileNotFoundException {
        BoxesHandler.getInstance().loadBoxes();
    }

    public boolean isPuchesable(){
        return (!BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition()).isPurchased()) && (BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition()).getCanBeBought());
    }

    public boolean isATax(){
        return BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition()).isATax();
    }

    public void addPlayer(String name, String pawn) throws NullNameException {
        PlayerHandler.getInstance().addPlayer(name,pawn);
    }
    
    public void start(){
        BoxesHandler.getInstance();
        PlayerHandler.getInstance();
    }

    public int getNumPlayers(){
        return PlayerHandler.getInstance().getNumPlayer();
    }

    public void startNewGame(){
        PlayerHandler.getInstance().setPlayerMoneyAndContracts();
    }
    
    public void loadGame() throws IOException {
        BoxesHandler.loadGame();
        PlayerHandler.loadGame();
    }

    public Player getPlayer(){
        return PlayerHandler.getInstance().getPlayer(this.turn);
    }

    public void removePlayer(){
        PlayerHandler.getInstance().removePlayer(this.turn);
    }

    public void changePosition(){

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

    public Boxes getPositionBox(){
        return BoxesHandler.getInstance().getContract(PlayerHandler.getInstance().getPlayer(this.turn).getPosition());
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
