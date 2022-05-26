package it.monopoly.GUI;

import it.monopoly.app.ContractsHandler;
import it.monopoly.app.PlayerHandler;

import javax.swing.*;
import java.awt.*;

public class ScoreboardFrame extends JFrame{
    public static final Dimension DEFAULT_DIMENSION = new Dimension(800,600);
    private ContractsHandler contractsHandler;
    public ScoreboardFrame(PlayerHandler playerHandler){
        super("Tabellone");
        contractsHandler = new ContractsHandler();
        ScoreBoardForm scoreboardForm = new ScoreBoardForm(contractsHandler,playerHandler);
        setContentPane(scoreboardForm.getPanel());
        setDeafultConfiguration();
    }

    private void setDeafultConfiguration() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
