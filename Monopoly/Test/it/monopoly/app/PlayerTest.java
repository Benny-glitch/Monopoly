package it.monopoly.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player  player = new Player("Benny", false, 0, "Nave da guerra", 0);
    BoxesHandler boxesHandler = BoxesHandler.getInstance();
    public PlayerTest() throws NullNameException {
    }

    @Test
    void testGetMoney() throws NullNameException {
        player.addMoney(100);
        int money = (int) player.getMoney();
        assertEquals(100, money);
    }

    @Test
    void testIsInJail(){
        boolean inJail = player.isInJail();
        assertFalse(inJail);
    }

    @Test
    void testGetUsername(){
        String username = player.getUsername();
        assertEquals("Benny", username);
    }

    @Test
    void testGetshiftsInJail(){
        int shiftsInJail = player.getShiftsInJail();
        assertEquals(0, shiftsInJail);
    }

    @Test
    void testSetMoney(){
        player.setMoney(100);
        assertEquals(100,player.getMoney());
    }

    @Test
    void testGetNumContracts(){
        int numsOfContracts = player.getNumContracts();
        assertEquals(0, numsOfContracts);
    }

    @Test
    void testGetRentContract(){
        player.setContracts(new Boxes("VIA",0,0,false,false));
        int rentContract = player.getRentContract(0);
        assertEquals(0, rentContract);
    }

    @Test
    void testGetPosition(){
        int position = player.getPosition();
        assertEquals(0,position);
    }

    @Test
    void testBuy(){
       player.buy(0);
       assertEquals(0, player.getMoney());
    }

    @Test
    void testGetPawn(){
        String pawn = player.getPawn();
        assertEquals("Nave da guerra", pawn);
    }

}
