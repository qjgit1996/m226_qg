package m226_1.minesweeper;

import java.util.Scanner;

public class SpielEngine {
    boolean gameOver;
    Spielmatrix matrix;
    public SpielEngine(Spielmatrix matrix) {
        this.gameOver = false;
        this.matrix = matrix;
    }

    public void start() {
        while (!this.gameOver) {
            this.matrix.matrixAusgeben();
            char[] inputSpieler = checkInput();
            zellenmarkierungAendern(inputSpieler);
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
                System.out.println("int");
                Integer.valueOf(spielzug[1]);
                Integer.valueOf(spielzug[2]);
                return spielzug;
            } catch (NumberFormatException e) {
                System.out.println("not int");
                return checkInput();
            }
        }
        else{
            return checkInput();
        }
    }

    public void zellenmarkierungAendern(char [] inputSpieler) {
        for (int i = 0; i < this.matrix.getMatrix().size(); i++) {
            if (this.matrix.getMatrix().get(i).getX() == Character.getNumericValue(inputSpieler[1]) && this.matrix.getMatrix().get(i).getY() == Character.getNumericValue(inputSpieler[2])) {
                Character inputChar = Character.toLowerCase(inputSpieler[0]);
                if (inputChar.equals('m')) {
                    this.matrix.getMatrix().get(i).markiertAendern();
                }
                if (inputChar.equals('t')) {
                    if (!this.matrix.getMatrix().get(i).getBombeAttribut()) {
                        this.matrix.getMatrix().get(i).aufgedecktAendern();
                    }
                    else {
                        this.gameOver = true;
                    }
                }
            }
            if (Character.getNumericValue(inputSpieler[1])-1 > 0) {
                int xmin = Character.getNumericValue(inputSpieler[1])-1;
            }
            if (Character.getNumericValue(inputSpieler[1])-1 <= 0) {
                int xmin = Character.getNumericValue(inputSpieler[1]);
            }
            if (Character.getNumericValue(inputSpieler[1])+1 <= this.matrix.getSize()) {
                int xmax = Character.getNumericValue(inputSpieler[1])+1;
            }
            if (Character.getNumericValue(inputSpieler[1])-1 > this.matrix.getSize()) {
                int xmax = Character.getNumericValue(inputSpieler[1]);
            }
            if (Character.getNumericValue(inputSpieler[2])-1 > 0) {
                int ymin = Character.getNumericValue(inputSpieler[2])-1;
            }
            if (Character.getNumericValue(inputSpieler[2])-1 <= 0) {
                int ymin = Character.getNumericValue(inputSpieler[2]);
            }
            if (Character.getNumericValue(inputSpieler[2])+1 <= this.matrix.getSize()) {
                int ymax = Character.getNumericValue(inputSpieler[2])+1;
            }
            if (Character.getNumericValue(inputSpieler[2])+1 > this.matrix.getSize()) {
                int ymax = Character.getNumericValue(inputSpieler[2]);
            }
            if (this.matrix.getMatrix().get(i).getX() == Character.getNumericValue(inputSpieler[1]) && this.matrix.getMatrix().get(i).getY() == Character.getNumericValue(inputSpieler[2])) {
                //nothing
            }
        }
    }
}
