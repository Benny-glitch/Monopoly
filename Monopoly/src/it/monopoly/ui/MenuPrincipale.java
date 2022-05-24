package it.monopoly.ui;


import java.util.Scanner;

import it.monopoly.app.GestoreContratti;
import it.monopoly.app.Giocatore;
import it.monopoly.app.GestoreGiocatori;

public class MenuPrincipale {
    GestoreGiocatori gestoreGiocatori = new GestoreGiocatori();
    SchermataTurno schermataTurno = new SchermataTurno();

    public void esegui() {
        System.out.println("Benvenuto");
        stampaMrMonopoly();
        boolean esci = false;
        do {
            stampaMenu();
            esci = inputScelta();
        } while (!esci);
    }

    private void stampaMrMonopoly() {
        System.out.println(
                "                                  -+ooo:       ++//++                                            \n" +
                        "                               -sy+-`dMN-     :+y++so                                    \n" +
                        "                             -hN:    -NMd`    +:y.                                       \n" +
                        "                            oNMMN:   .sNdy`   .y:y:                                      \n" +
                        "                           +mMMMMN+++-`-mMh.-h+`o++s`                                    \n" +
                        "                           +s+NMMhs. `.-+ydmm-   -s:s:                                   \n" +
                        "                   -:       :homshmysy+/:-`.ss`   `/o+s`                                 \n" +
                        "                  osh        :dsdso+:o+`    `:y     `s+sos+-                             \n" +
                        "              ./syh`h`       .d++y-  - `    :/o/      oy+s:/o`                           \n" +
                        "           .+ys:.`o :mo+/.   h/sh//   -s  `/  -y`.   `y-so` :+                           \n" +
                        "          oso++   ` +osMMNh+`d:Ny:.      `.do+/ds+    s`o:o/`o                           \n" +
                        "         .y-/o++oooy+yMMMMMMNddm:   `  -o/``  .-y-   :yh+yysyy+                          \n" +
                        "          `soo/-`` `:dMMMMMMMMMNhy+o`so++  `o/:+s-   .md+hss/.yyy.                       \n" +
                        "                    `./smMMMMMMMNdMd:++//os/.y/    :mMMNooh`  /yy+                       \n" +
                        "                         -yMMMMMMMMMhs+-.`.+mdo++smMMMMMMNo    `oys-                     \n" +
                        "                           -dMMMMMMMd ++++:ohMMMMMMMMMMMMh.      -yy+`                   \n" +
                        "                            `dMMMMMMM/sssosodMMMMMMMMMMm/         `+ys-                  \n" +
                        "                             :MMMMMMMN/`  `:MMMMMMMMMd+`            .s:                  \n" +
                        "                             /MNhdhdMM/    sMMMMMNho-                                    \n" +
                        "   Y8b Y8b Y888P 888'Y88 888       e88'Y88   e88 88e       e   e     888'Y88             \n" +
                        "    Y8b Y8b Y8P  888 ,'Y 888      d888  'Y  d888 888b     d8b d8b    888 ,'Y             \n" +
                        "     Y8b Y8b Y   888C8   888     C8888     C8888 8888D   e Y8b Y8b   888C8               \n" +
                        "      Y8b Y8b    888 \",d 888  ,d  Y888  ,d  Y888 888P   d8b Y8b Y8b  888 \",d           \n" +
                        "       Y8P Y     888,d88 888,d88   \"88,d88   \"88 88\"   d888b Y8b Y8b 888,d88          \n" +
                        "                                                                                         \n" +
                        "                               88P'888'Y88   e88 88e                                     \n" +
                        "                               P'  888  'Y  d888 888b                                    \n" +
                        "                                   888     C8888 8888D                                   \n" +
                        "                                   888      Y888 888P                                    \n" +
                        "                                   888       \"88 88\"                                   \n" +
                        "                                                                                         \n" +
                        "    e   e       e88 88e   Y88b Y88   e88 88e   888 88e    e88 88e   888     Y88b Y8P     \n" +
                        "   d8b d8b     d888 888b   Y88b Y8  d888 888b  888 888D  d888 888b  888      Y88b Y      \n" +
                        "  e Y8b Y8b   C8888 8888D b Y88b Y C8888 8888D 888 88\"  C8888 8888D 888       Y88b      \n" +
                        " d8b Y8b Y8b   Y888 888P  8b Y88b   Y888 888P  888       Y888 888P  888  ,d    888       \n" +
                        "d888b Y8b Y8b   \"88 88\"   88b Y88b   \"88 88\"   888        \"88 88\"   888,d88    888 \n");
    }

    private void stampaMenu() {
        System.out.println("1. Nuovo giocatore");
        System.out.println("2. Avvia gioco");
        System.out.println("0. Esci");
    }

    public boolean inputScelta() {
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        switch (scelta) {
            case 1:
                if(gestoreGiocatori.getNumgiocatori() <= 6){
                    avviaInserimentoGiocatore();
                }else{
                    System.out.println("Hai raggiunto il limite massimo di giocatori");
                }
                return false;
            case 2:
                if (gestoreGiocatori.getNumgiocatori() >= 2) {
                    Avviailgioco();
                } else {
                    System.out.println("Non si può avviare il gioco con meno di due giocatori");
                }
                return false;
            case 3:
                for(int i = 0; i < gestoreGiocatori.getNumgiocatori(); i++){
                    System.out.println(gestoreGiocatori.getGiocatore(i).toString().replace("[", " ").replace("]", " ") + "\n");
                }
                return false;
            case 0:
                return true;
            default:
                System.out.println("Scelta non valida");
                return false;
        }
    }

    private void avviaInserimentoGiocatore() {
        boolean same_name = false;
        String nome;
        Scanner scanner1 = new Scanner(System.in);
        do{
            System.out.print("Nome giocatore: ");
            nome = scanner1.nextLine();
            for(int i = 0; i < gestoreGiocatori.getNumgiocatori(); i++){
                if(nome.equals(gestoreGiocatori.getGiocatore(i).getUsername())){
                    System.out.println("Il nome e' gia' stato inserito.");
                    same_name = true;
                }else{
                    same_name = false;
                }
            }
        }while(same_name);
      //  gestoreGiocatori.addGiocatore(nome);
    }

    private void Avviailgioco() {
        gestoreGiocatori.setGiocatoreSoldiEcontratti(); //qui setto i contratti e i soldi in base al numero dei giocatori
    }


}

