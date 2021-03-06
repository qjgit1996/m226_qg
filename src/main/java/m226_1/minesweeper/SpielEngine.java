package m226_1.minesweeper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.util.Scanner;

public class SpielEngine {
    private boolean gameOver;
    private Spielmatrix matrix;
    private char[] inputSpieler;
    public SpielEngine(Spielmatrix matrix) {
        this.gameOver = false;
        this.matrix = matrix;
        this.inputSpieler = inputSpieler;
    }

    public void start() {
        while (!this.gameOver) {
            this.matrix.matrixAusgeben();
            this.inputSpieler = checkInput();
            zellenmarkierungAendern();
        }

    }
    public char[] checkInput() {
        System.out.println();
        System.out.println("Where are the bombs?");
        System.out.println("1. Which field do you want to uncover? -> T Or mark maybe one as a bomb? -> M");
        System.out.println("2. Choose the x coordinate you want to check");
        System.out.println("3. Choose the y coordinate you want to check");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String inputString = myObj.nextLine();
        char [] spielzug = inputString.toCharArray();
        Character testVariable = Character.toLowerCase(spielzug[0]);
        if (testVariable.equals('m') || testVariable.equals('t')) {
            try {
                Integer.valueOf(spielzug[1]);
                Integer.valueOf(spielzug[2]);
                return spielzug;
            } catch (NumberFormatException e) {
                System.out.println("That input was not valid!");
                return checkInput();
            }
        }
        else{
            return checkInput();
        }
    }

    public void zellenmarkierungAendern() {
        for (int i = 0; i < this.matrix.getMatrix().size(); i++) {
            if (this.matrix.getMatrix().get(i).getX() == Character.getNumericValue(this.inputSpieler[1]) && this.matrix.getMatrix().get(i).getY() == Character.getNumericValue(this.inputSpieler[2])) {
                Character inputChar = Character.toLowerCase(this.inputSpieler[0]);
                if (inputChar.equals('m')) {
                    this.matrix.getMatrix().get(i).markiertAendern();
                }
                if (inputChar.equals('t')) {
                    if (!this.matrix.getMatrix().get(i).getBombeAttribut()) {
                        int anzahlTiefen = 0;
                        dreierMatrixAlgorithmus(this.matrix.getMatrix().get(i), anzahlTiefen);
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
        for (int i = 0; i < dreierMatrix.length; i++) {
            if (dreierMatrix[i].getBombeAttribut())
            {
                zelle.setBenachbarteBomben();
                anzahlBomben++;
            }
        }
        if (anzahlTiefen <= 0 && anzahlBomben <= 1) {
            anzahlTiefen++;
            for (int i = 0; i < dreierMatrix.length; i++) {
                if (!dreierMatrix[i].getBombeAttribut()) {
                    System.out.println(anzahlTiefen);
                    dreierMatrixAlgorithmus(dreierMatrix[i], anzahlTiefen);
                }
            }
        }
    }

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
