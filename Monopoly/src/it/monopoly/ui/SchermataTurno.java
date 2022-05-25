package it.monopoly.ui;

import java.util.*;

import it.monopoly.app.ContractsHandler;
import it.monopoly.app.Player;


public class SchermataTurno {
    private int num_player;
    private ArrayList<Player> giocatori = new ArrayList<>();
    private ContractsHandler contractsHandler;
    boolean terminaTurno;

    public void SchermataTurno(ArrayList<Player> player, ContractsHandler contratti) {
        this.contractsHandler = contratti;
        this.giocatori = player;
        this.num_player = this.giocatori.size();
        this.avviaTurno();
    }

    public void avviaTurno() {
        while (this.num_player > 1) {
            for (int i = 0; i < this.giocatori.size(); i++) {
                if (this.num_player == 1) {
                    System.out.println("Il giocatore " + giocatori.get(i).getUsername() + " ha vinto");
                } else {
                    if (!this.giocatori.get(i).getIsinjail()) {
                        if (this.giocatori.get(i).getMoney() > 0) {
                            terminaTurno = false;
                            do {
                                System.out.println("Il turno del giocatore " + giocatori.get(i).getUsername() + "\n");
                                stampaMenu();
                                terminaTurno = inputScelta(i);
                            } while (!terminaTurno);
                        } else {
                            System.out.println("Il giocatore "+ giocatori.get(i).getUsername() + " ha finito i soldi");
                            num_player--;
                            giocatori.remove(i);
                        }
                    } else {
                        System.out.println("Il giocatore " + giocatori.get(i).getUsername() + " e' in prigione per " + giocatori.get(i).getShiftsinjail() + " turni");
                        Prigione(i);
                    }
                }
            }
        }
    }

    private void stampaMenu() {
        System.out.println("1. Mostra Contratti posseduti");
        System.out.println("2. Acquista contratto");
        System.out.println("3. Paga un affitto");
        System.out.println("4. Paga una tassa");
        System.out.println("5. Passa dal via");
        System.out.println("6. Vai in prigione");
        System.out.println("0. Termina turno");
    }

    private boolean inputScelta(int i) {
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                ContrattiPosseduti(i);
                return false;
            case 2:
                AcquistaContratto(i);
                return false;
            case 3:
                PagaAffitto(i);
                return false;
            case 4:
                Pagaunatassa(i);
                return false;
            case 5:
                Passadalvia(i, 500);
                return false;
            case 6:
                vaiInprigione(i);
                return false;
            case 7:
                for (int j = 0; j < giocatori.size(); j++) {
                    System.out.println(giocatori.get(j).toString().replace("[", " ").replace("]", " ") + "\n");
                }
            case 0:
                return true;
            default:
                System.out.println("Scelta non valida");
                return false;
        }
    }

    private void ContrattiPosseduti(int i) {
        System.out.println(this.giocatori.get(i).getContractListString());
    }

    private void AcquistaContratto(int i) {
        int id_contratto;
        boolean acquistato = false;
        Scanner scanner1 = new Scanner(System.in);
        do{
            System.out.println(this.contractsHandler.ContrattoLibero().replace("null", ""));
            System.out.println("Inserisci l'ID del contratto");
            id_contratto = scanner1.nextInt();
            if(contractsHandler.get(id_contratto).getAcquistato()){
                System.out.println("Contratto gia' acquistato \n");
                acquistato = true;
            }else{
                giocatori.get(i).setContracts(contractsHandler.get(id_contratto));
                contractsHandler.get(id_contratto).setAcquistato();
                acquistato = false;
            }
        }while(acquistato);
    }

    private void PagaAffitto(int i) {
        Scanner scanner = new Scanner(System.in);
        int[] player_ingame = new int[giocatori.size() - 1];
        boolean wrong_id = false;
        int id_giocatore;
        for (int j = 0; j < giocatori.size(); j++) {
            if (i != j) {
                System.out.println(j + ".Nome giocatore: " + giocatori.get(j).getUsername() + "\n");
                System.out.println("Lista contratti: \n" + giocatori.get(j).getContractListString().replace("null", ""));
                player_ingame[i] = j;
            }
        }
        do{
            System.out.println("A quale giocatore vuoi pagare l'affitto(numero che precede il nome del giocatore):");
            id_giocatore = scanner.nextInt();
            for(int k = 0; k < player_ingame.length; k++){
                if(id_giocatore != player_ingame[i]){
                    System.out.println("id giocatore non valido");
                    wrong_id = true;
                }else{
                    wrong_id = false;
                }
            }
        }while(wrong_id);

        System.out.println("Inserisci l'id del contratto da pagare: ");
        int id_contratto = scanner.nextInt();
        int tassa = giocatori.get(id_giocatore).getRentContract(id_contratto);
        giocatori.get(i).addMoney(-tassa);
        giocatori.get(id_giocatore).addMoney(tassa);
    }

    private void Pagaunatassa(int i) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la quantita' di denaro da togliere(causa: Imprevisti, probabilia' o tasse)");
        int denaro = scanner.nextInt();
        giocatori.get(i).addMoney(-denaro);
        System.out.println("Ti sono stati decurtati " + denaro);
    }

    private void Passadalvia(int i, int money) {
        this.giocatori.get(i).addMoney(money);
        System.out.println("Ti sono stati aggiunti 500$ per essere passato dal via");
    }

    private void vaiInprigione(int i) {
        giocatori.get(i).setIsinjail(true);
        giocatori.get(i).setShiftsinjail(1);
        System.out.println("Sei in prigione");
    }

    private void Prigione(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Prigione:");
        System.out.println("1.Esci gratis \n2.Esci Pagando(Ti verra decurtata una tassa) \n3.Resta in prigione");
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1 -> {
                System.out.println("Non sei piu' in prigione");
                giocatori.get(i).setShiftsinjail(0);
                giocatori.get(i).setIsinjail(false);
                this.avviaTurno();
            }
            case 2 -> {
                giocatori.get(i).addMoney(-125);
                System.out.println("Sei uscito dalla prigione ma ti sono stati decurtati 125$");
                giocatori.get(i).setIsinjail(false);
            }
            case 3 -> System.out.println("Resterai in prigione un'altro turno\n");
        }
    }

}
