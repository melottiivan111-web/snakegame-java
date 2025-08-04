package snakegame;

/**
 * 17/06/2017 Ivan Melotti 4di
 */
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;

public class SnakeGame extends javax.swing.JFrame {

    ImageIcon icon = new ImageIcon("Game Over.png");
    static int countAzion = 0;                        //contatore di azioni 
    final static int BORDO = -1;                      //costante che segnala nella matrice che si tratta di un bordo
    final static int VUOTO = 0;                       //costante che segnala nella matrice che si tratta di una zona vuota
    static int headX;                               //coordinata X della prima parte del serpente
    static int headY;                               //coordinata Y della prima parte del serpente
    static int tailX;                               //coordinata X dell'ultima parte del serprente
    static int tailY;                               //coordinata Y dell'ultima parte del serpente
    static int inizio = 2;                            //nella matrice il primo numero che andrà ad identificare il serprente sarà "2"
    static int campo[][] = new int[400][400];         //area del campo di gioco e della matrice
    final static int XCAMPO = 50;                     //costante (X) che rappresenta la distanza tra il primo pixel e l'inizio del campo
    final static int YCAMPO = 50;                     //costante (Y) che rappresenta la distanza tra il primo pixel e l'inizio del campo
    static int SNAKELUNG = 5;                         //grandezza massima iniziale del serpente
    static int countLung = 1;                         //contatore per vedere quanto è lungo il serpente
    static int posmini = 0;
    static int posminj = 0;                           //variabili per trovare l'head e tail dentro la matrice
    static int posmaxi = campo.length - 1;
    static int posmaxj = campo[0].length - 1;
    final static int MELA = 1;                        //costante che segnala nella matrice che si tratta di una mela 
    static int melaX;
    static int melaY;                               //Coordinata X,Y della mela
    static int punteggio = 0;                         //variabile che contiene i punti acquisiti durante il gioco
    static boolean sinistra = false;
    static boolean destra = false;                    //ultimi spostamenti
    static boolean sopra = false;
    static boolean sotto = false;

    public SnakeGame() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SnakeGame");
        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gestisciComandi(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click
        //se viene cliccato sul JFRAME inizieranno una serie di istruzioni che serviranno per iniziare a giocare
        if (countAzion == 0) {
            //riempimento matrice
            for (int i = 0; i < campo.length; i++) {
                for (int j = 0; j < campo[i].length; j++) {
                    //i contorni della matrice sono riempiti con la variabile BORDO
                    if (i == 0 || j == 0 || i == campo.length - 1 || j == campo[0].length - 1) {
                        campo[i][j] = BORDO;
                    } //il centro della matrice è il punto d'inizio del serpente
                    else if (i == (campo.length - 1) / 2 && j == (campo[0].length - 1) / 2) {     //punto di inizio
                        campo[i][j] = inizio;
                        headX = i;
                        headY = j;
                        tailX = i;
                        tailY = j;
                    } //tutto il resto è riempito con la variabile VUOTO
                    else {
                        campo[i][j] = VUOTO;
                    }
                }
            }
            repaint();      //stampa la prima parte del campo
            gestisciMele(); //creazione della prima mela
            countAzion++;   //fine delle istruzioni iniziali per la preparazione al gioco
        }
    }//GEN-LAST:event_click
    public void cercaTestaeCoda() {
        //cerca il numero maggiore nella matrice che equivale alla testa del serpente
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] > campo[posmaxi][posmaxj]) {
                    posmaxi = i;
                    posmaxj = j;
                    posmini = i;
                    posminj = j;
                }
            }
        }
        //cerca il numero minore nella matrice che equivale alla coda del serpente
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] == BORDO || campo[i][j] == VUOTO) {

                } else if (campo[i][j] < campo[posmini][posminj] && campo[i][j] != MELA) {
                    posmini = i;
                    posminj = j;
                }
            }
        }
        headX = posmaxi;
        headY = posmaxj;
        tailX = posmini;
        tailY = posminj;
    }

    private void gestisciComandi(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gestisciComandi
        switch (evt.getKeyCode()) {
            //se va a sinistra
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                sinistra = true;      //memorizza che l'ultimo spostamento è stato effettuato a sinistra
                destra = false;
                sotto = false;
                sopra = false;
                vaAsinistra();
                break;
            //se va a destra
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                sinistra = false;
                destra = true;       //memorizza che l'ultimo spostamento è stato effettuato a destra
                sotto = false;
                sopra = false;
                vaAdestra();
                break;
            //se va di sopra
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = true;        //memorizza che l'ultimo spostamento è stato effettuato verso l'alto
                vaSopra();
                break;
            //se va di sotto
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                sinistra = false;
                destra = false;
                sotto = true;         //memorizza che l'ultimo spostamento è stato effettuato verso il basso
                sopra = false;
                vaSotto();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_gestisciComandi
    public void gestisciMele() {
        melaX = (int) (Math.random() * campo.length);                            //generazione delle coordinate della mela
        melaY = (int) (Math.random() * campo[0].length);
        if (campo[melaX][melaY] == VUOTO) {
            campo[melaX][melaY] = MELA;
            repaint();
        } else {
            gestisciMele();
        }
    }

    public void vaAsinistra() {
        cercaTestaeCoda();                                                      //cerca la testa e la coda del serpente 
        if (sinistra == true) {
            if (countLung < SNAKELUNG) {                                          //se non ha ancora raggiunto la distanza minima... 
                //se tocca il bordo o se stesso
                if (campo[headX - 1][headY] == BORDO || campo[headX - 1][headY] >= 2) {
                    sinistra = false;
                    destra = false;
                    sotto = false;
                    sopra = false;
                    JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                    System.exit(0);
                }
                //se mangi una mela
                if (campo[headX - 1][headY] == MELA) {
                    punteggio = punteggio + 10;
                    gestisciMele();
                    SNAKELUNG++;
                }
                campo[headX - 1][headY] = inizio + 1;
                inizio++;
                repaint();
                countLung++;
            } else {
                //se ha già raggiunto la langhezza massima
                if (campo[headX - 1][headY] == BORDO || campo[headX - 1][headY] >= 2) {
                    sinistra = false;
                    destra = false;
                    sotto = false;
                    sopra = false;
                    JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                    System.exit(0);
                }
                //se mangia una mela
                if (campo[headX - 1][headY] == MELA) {
                    punteggio = punteggio + 10;
                    gestisciMele();
                    SNAKELUNG++;
                }
                campo[headX - 1][headY] = inizio + 1;
                campo[tailX][tailY] = VUOTO;
                inizio++;
                repaint();
            }
        }
    }

    public void vaAdestra() {
        cercaTestaeCoda();                                                      //cerca la testa e la coda 
        if (countLung < SNAKELUNG) {                                              //se non ha ancora raggiunto la distanza minima... 
            if (campo[headX + 1][headY] == BORDO || campo[headX + 1][headY] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX + 1][headY] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;

            }
            campo[headX + 1][headY] = inizio + 1;
            inizio++;
            repaint();
            countLung++;
        } else {
            //se ha già raggiunto la langhezza massima
            if (campo[headX + 1][headY] == BORDO || campo[headX + 1][headY] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX + 1][headY] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;
            }
            campo[headX + 1][headY] = inizio + 1;
            campo[tailX][tailY] = VUOTO;
            inizio++;
            repaint();
        }
    }

    public void vaSotto() {
        cercaTestaeCoda();
        if (countLung < SNAKELUNG) {
            //se non ha ancora raggiunto la distanza minima...
            if (campo[headX][headY + 1] == BORDO || campo[headX][headY + 1] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX][headY + 1] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;
            }
            campo[headX][headY + 1] = inizio + 1;
            inizio++;
            repaint();
            countLung++;
        } else {
            //se ha già raggiunto la langhezza massima
            if (campo[headX][headY + 1] == BORDO || campo[headX][headY + 1] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX][headY + 1] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;
            }
            campo[headX][headY + 1] = inizio + 1;
            campo[tailX][tailY] = VUOTO;
            inizio++;
            repaint();
        }
    }

    public void vaSopra() {
        cercaTestaeCoda();
        if (countLung < SNAKELUNG) {                                              //se non ha ancora raggiunto la distanza minima...
            if (campo[headX][headY - 1] == BORDO || campo[headX][headY - 1] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX][headY - 1] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;
            }
            campo[headX][headY - 1] = inizio + 1;
            inizio++;
            repaint();
            countLung++;
        } else {
            //se ha già raggiunto la langhezza massima
            if (campo[headX][headY - 1] == BORDO || campo[headX][headY - 1] >= 2) {
                sinistra = false;
                destra = false;
                sotto = false;
                sopra = false;
                JOptionPane.showMessageDialog(null, "Hai totalizzato: " + punteggio + " punti ", "", JOptionPane.INFORMATION_MESSAGE, icon);
                System.exit(0);
            }
            if (campo[headX][headY - 1] == MELA) {
                punteggio = punteggio + 10;
                gestisciMele();
                SNAKELUNG++;
            }
            campo[headX][headY - 1] = inizio + 1;
            campo[tailX][tailY] = VUOTO;
            inizio++;
            repaint();
        }
    }

    public void timer() {
        for (int i = 0; i < 3000; i++) {                                                //dopo queste istruzioni
            for (int j = 0; j < 3000; j++) {
            }
        }
        //ripete l'ultimo spostamento effettuato
        if (sinistra == true) {
            vaAsinistra();
        } else if (destra == true) {
            vaAdestra();
        } else if (sotto == true) {
            vaSotto();
        } else if (sopra == true) {
            vaSopra();
        }
    }

    public void paint(Graphics g) {
        cercaTestaeCoda();

        if (countAzion == 0) {                                                          //stampa campo
            g.setColor(Color.WHITE);
            g.drawLine(XCAMPO, YCAMPO, XCAMPO + campo.length, YCAMPO);
            g.drawLine(XCAMPO, YCAMPO, XCAMPO, YCAMPO + campo[0].length);
            g.drawLine(XCAMPO, YCAMPO + campo[0].length, XCAMPO + campo.length, YCAMPO + campo[0].length);
            g.drawLine(XCAMPO + campo.length, YCAMPO + campo[0].length, XCAMPO + campo.length, YCAMPO);
        }

        for (int i = 1; i < campo.length - 1; i++) {
            for (int j = 1; j < campo[i].length - 1; j++) {
                if (campo[i][j] == MELA) {
                    g.setColor(Color.RED);
                    g.drawLine(i + XCAMPO, j + YCAMPO, i + XCAMPO, j + YCAMPO);
                } else if (campo[i][j] == campo[headX][headY] && campo[i][j] != VUOTO) {
                    g.setColor(Color.MAGENTA);
                    g.drawLine(i + XCAMPO, j + YCAMPO, i + XCAMPO, j + YCAMPO);
                } else if (campo[i][j] != VUOTO && campo[i][j] != MELA && campo[i][j] != BORDO) {
                    g.setColor(Color.GREEN);
                    g.drawLine(i + XCAMPO, j + YCAMPO, i + XCAMPO, j + YCAMPO);
                } else {
                    g.setColor(Color.BLACK);
                    g.drawLine(i + XCAMPO, j + YCAMPO, i + XCAMPO, j + YCAMPO);
                }
            }
        }
        timer();

    }

    public static void main(String args[]) {

        JOptionPane.showMessageDialog(null, "Fai doppio click sulla prossima finestra per iniziare a giocare");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnakeGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
