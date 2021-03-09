package m226_1.minesweeper;

import java.util.Scanner;

/**
 * Diese Klasse führt alle Berechnungen des Spiels durch.
 * @author Quinten Groenveld
 * @version 1.1
 */
public class SpielEngine {
    private boolean gameOver;
    private Spielmatrix matrix;
    private String[] inputSpieler;

    /**
     * Konstruktor Funktion für die Spielengine.
     *
     * @param matrix Stellt die Spielmatrix dar mit den gespeicherten Zellen/Bomben.
     */
    public SpielEngine(Spielmatrix matrix) {
        this.gameOver = false;
        this.matrix = matrix;
    }

    /**
     * Regelt den Spielablauf und sorgt, dass das Spiel im richtigen Moment gestoppt wird.
     */
    public void start() {
        while (!this.gameOver) {
            this.matrix.matrixAusgeben();
            this.inputSpieler = checkInput();
            zellenmarkierungAendern();
        }

    }

    /**
     * Kontrolliert den Input des Spielenden und gibt den Input zurück, wenn er gültig ist.
     *
     * @return Gültigen Input des Spielenden.
     */
    public String[] checkInput() {
        System.out.println();
        System.out.println("Where are the bombs?");
        System.out.println("1. Which field do you want to uncover? -> T Or mark maybe one as a bomb? -> M");
        System.out.println("2. Choose the x coordinate you want to check");
        System.out.println("3. Choose the y coordinate you want to check");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String inputString = myObj.nextLine();
        char[] spielzug = inputString.toCharArray();
        Character testVariable = Character.toLowerCase(spielzug[0]);
        if (testVariable.equals('m') || testVariable.equals('t') && spielzug.length>3) {
            String[] korrekterSpielzug = new String[3];
            korrekterSpielzug[0] = testVariable.toString();
            try {
                if (spielzug.length == 5) {
                    if (spielzug[2] == ',') {
                        StringBuilder sb2 = new StringBuilder().append(spielzug[3]).append(spielzug[4]);
                        Integer.valueOf(sb2.toString());
                        Integer.valueOf(spielzug[1]);
                        korrekterSpielzug[1] = Character.toString(spielzug[1]);
                        korrekterSpielzug[2] = sb2.toString();
                        return korrekterSpielzug;
                    }
                    else {
                        StringBuilder sb2 = new StringBuilder().append(spielzug[1]).append(spielzug[2]);
                        Integer.valueOf(sb2.toString());
                        Integer.valueOf(spielzug[4]);
                        korrekterSpielzug[2] = Character.toString(spielzug[4]);
                        korrekterSpielzug[1] = sb2.toString();
                        return korrekterSpielzug;
                    }
                }
                else if (spielzug.length == 6) {
                    if (spielzug[3] == ',') {
                        StringBuilder sb1 = new StringBuilder().append(spielzug[1]).append(spielzug[2]);
                        StringBuilder sb2 = new StringBuilder().append(spielzug[4]).append(spielzug[5]);
                        Integer.valueOf(sb1.toString());
                        Integer.valueOf(sb2.toString());
                        korrekterSpielzug[1] = sb1.toString();
                        korrekterSpielzug[2] = sb2.toString();
                        return korrekterSpielzug;
                    }
                    else if (spielzug[4] == ',') {
                        StringBuilder sb1 = new StringBuilder().append(spielzug[1]).append(spielzug[2]).append(spielzug[3]);
                        Integer.valueOf(sb1.toString());
                        Integer.valueOf(spielzug[5]);
                        korrekterSpielzug[2] = Character.toString(spielzug[5]);
                        korrekterSpielzug[1] = sb1.toString();
                        return korrekterSpielzug;
                    }
                    else {
                        StringBuilder sb1 = new StringBuilder().append(spielzug[3]).append(spielzug[4]).append(spielzug[5]);
                        Integer.valueOf(sb1.toString());
                        Integer.valueOf(spielzug[1]);
                        korrekterSpielzug[1] = Character.toString(spielzug[1]);
                        korrekterSpielzug[2] = sb1.toString();
                        return korrekterSpielzug;
                    }
                }
                else if (spielzug.length == 7) {
                    if (spielzug[3] == ',') {
                        StringBuilder sb1 = new StringBuilder().append(spielzug[1]).append(spielzug[2]);
                        StringBuilder sb2 = new StringBuilder().append(spielzug[4]).append(spielzug[5]).append(spielzug[6]);
                        Integer.valueOf(sb1.toString());
                        Integer.valueOf(sb2.toString());
                        korrekterSpielzug[1] = sb1.toString();
                        korrekterSpielzug[2] = sb2.toString();
                        return korrekterSpielzug;
                    }
                    else {
                        StringBuilder sb1 = new StringBuilder().append(spielzug[1]).append(spielzug[2]).append(spielzug[3]);
                        StringBuilder sb2 = new StringBuilder().append(spielzug[5]).append(spielzug[6]);
                        Integer.valueOf(sb1.toString());
                        Integer.valueOf(sb2.toString());
                        korrekterSpielzug[1] = sb1.toString();
                        korrekterSpielzug[2] = sb2.toString();
                        return korrekterSpielzug;
                    }
                }
                else if (spielzug.length == 8) {
                    StringBuilder sb1 = new StringBuilder().append(spielzug[1]).append(spielzug[2]).append(spielzug[3]);
                    StringBuilder sb2 = new StringBuilder().append(spielzug[5]).append(spielzug[6]).append(spielzug[7]);
                    Integer.valueOf(sb1.toString());
                    Integer.valueOf(sb2.toString());
                    korrekterSpielzug[1] = sb1.toString();
                    korrekterSpielzug[2] = sb2.toString();
                    return korrekterSpielzug;
                }
                else {
                    System.out.println(spielzug);
                    Integer.valueOf(spielzug[1]);
                    Integer.valueOf(spielzug[3]);
                    korrekterSpielzug[1] = Character.toString(spielzug[1]);
                    korrekterSpielzug[2] = Character.toString(spielzug[3]);
                    return korrekterSpielzug;
                }
            } catch (NumberFormatException e) {
                System.out.println("That input was not valid!");
                return checkInput();
            }
        } else {
            System.out.println("That input was not valid!");
            return checkInput();
        }
    }

    /**
     * Bearbeitet den Input des Spielenden. Markierungen oder Aufdecken von Zellen.
     */
    public void zellenmarkierungAendern() {
        for (int i = 0; i < this.matrix.getMatrix().size(); i++) {
            if (this.matrix.getMatrix().get(i).getX() == Integer.parseInt(this.inputSpieler[1]) && this.matrix.getMatrix().get(i).getY() == Integer.parseInt(this.inputSpieler[2])) {
                String inputChar = this.inputSpieler[0].toLowerCase();
                if (inputChar.equals("m")) {
                    this.matrix.getMatrix().get(i).markiertAendern();
                }
                if (inputChar.equals("t")) {
                    if (!this.matrix.getMatrix().get(i).getBombeAttribut()) {
                        dreierMatrixAlgorithmusV2(this.matrix.getMatrix().get(i));
                        //int anzahlTiefen = 0;
                        //dreierMatrixAlgorithmus(this.matrix.getMatrix().get(i), anzahlTiefen);
                    }
                    else {
                        System.out.println("That was a bomb! Game Over!!");
                        this.gameOver = true;
                    }
                }
            }
            checkGameOver();
        }
    }

    /**
     * Ermöglicht dem Spielenden mehr Felder aufzudecken, wenn wenig Bomben in der Nähe sind.
     * @param zelle Zelle, welche aufgedeckt wurde.
     * @param anzahlTiefen Integer, welche Rekursionstiefe definiert.
     */
    public void dreierMatrixAlgorithmus(Zelle zelle, int anzahlTiefen) {
        int anzahlBomben = 0;
        if (!zelle.getBombeAttribut()) {
            zelle.aufgedecktAendern();
        }
        Zelle[] dreierMatrix = this.matrix.getMatrix().stream().filter(e -> e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()+1).toArray(Zelle[]::new);
        if (!zelle.getGezaehlt()) {
            for (int i = 0; i < dreierMatrix.length; i++) {
                if (dreierMatrix[i].getBombeAttribut()) {
                    zelle.setBenachbarteBomben();
                    anzahlBomben++;
                }
            }
            zelle.setGezaehlt();
        }
        if (anzahlTiefen <= 0 && anzahlBomben <= 1) {
            anzahlTiefen++;
            for (int i = 0; i < dreierMatrix.length; i++) {
                if (!dreierMatrix[i].getBombeAttribut()) {
                    dreierMatrixAlgorithmus(dreierMatrix[i], anzahlTiefen);
                }
            }
        }
    }

    /**
     * Ermöglicht dem Spielenden mehr Felder aufzudecken, wenn wenig Bomben in der Nähe sind.
     * @param zelle Zelle, welche aufgedeckt wurde.
     */
    public void dreierMatrixAlgorithmusV2(Zelle zelle) {
        if (!zelle.getBombeAttribut()) {
            zelle.aufgedecktAendern();
        }
        if (!zelle.getGezaehlt()) {
            bombenZaehlen(zelle);
        }
        Zelle[] dreierMatrix = this.matrix.getMatrix().stream().filter(e -> e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()+1).toArray(Zelle[]::new);

        for (int i = 0; i < dreierMatrix.length; i++) {
            if (!dreierMatrix[i].getBombeAttribut()) {
                bombenZaehlen(dreierMatrix[i]);
                dreierMatrix[i].aufgedecktAendern();
            }
            if (!dreierMatrix[i].getBombeAttribut() && dreierMatrix[i].getGezaehlt() && dreierMatrix[i].getBenachbarteBomben() == 0 && !dreierMatrix[i].getIteriert()) {
                dreierMatrix[i].setIteriert();
                dreierMatrixAlgorithmusV2(dreierMatrix[i]);
            }
        }
    }

    public void bombenZaehlen(Zelle zelle) {
        Zelle[] dreierMatrix = this.matrix.getMatrix().stream().filter(e -> e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()+1).toArray(Zelle[]::new);
        if (!zelle.getGezaehlt()) {
            for (int i = 0; i < dreierMatrix.length; i++) {
                if (dreierMatrix[i].getBombeAttribut()) {
                    zelle.setBenachbarteBomben();
                }
            }
            zelle.setGezaehlt();
        }
    }

    /**
     * Kontrolliert nach jedem Spielzug, ob das Spiel fertig ist oder nicht.
     */
    public void checkGameOver() {
        int alle = 0;
        for (int i = 0; i < this.matrix.getMatrix().size(); i++) {
            if (this.matrix.getMatrix().get(i).getMarkiert() && this.matrix.getMatrix().get(i).getBombeAttribut()) {
                alle++;
                if (alle == this.matrix.getBomben().size()) {
                    System.out.println("You found all bombs!! Congrats ***");
                    this.gameOver = true;
                }
            }
        }
    }
}
