package m226_1.minesweeper;

import java.util.Scanner;

public class SpielEngine {
    boolean gameOver;
    public SpielEngine() {
        this.gameOver = false;;
    }

    public void start() {
        while (this.gameOver == false) {
            System.out.println("Where are the bombs?");
            System.out.println("1. Do you want to uncover the field (T) or mark it as bomb (M)?");
            System.out.println("2. Choose the x coordinate you want to check");
            System.out.println("3. Choose the y coordinate you want to check");
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String inputString = myObj.nextLine();
            char [] spielzug = inputString.toCharArray();
        }


    }
}
