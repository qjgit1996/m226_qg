package m226_1.minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Spielmatrix {
    private ArrayList<Zelle> matrix = new ArrayList<>();
    private ArrayList<Zelle> bomben = new ArrayList<>();
    private int size;
    private int wahrscheinlichkeit;

    public Spielmatrix() {
        this.matrix = matrix;
        this.bomben = bomben;
        this.size = size;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

    public void zellenHinzufuegen() {
        Random rnd = new Random();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int x = i+1;
                int y = j+1;
                int wahlBombe = rnd.nextInt(this.wahrscheinlichkeit);
                if (wahlBombe == 1) {
                    Zelle zelle = new Zelle(x, y, true);
                    this.matrix.add(zelle);
                    this.bomben.add(zelle);
                    System.out.println(zelle.getX() + " " +zelle.getY());
                }
                else{
                    Zelle zelle = new Zelle(x, y, false);
                    this.matrix.add(zelle);

                }
            }
        }
    }

    public void matrixAusgeben() {
        int zeile = 0;
        int diff = 1;
        int computedSize = (this.size+1) * (this.size+1);
        for (int i = 0; i <= computedSize-1; i++) {
            if (zeile == 0) {
                if (i == 0) {
                    System.out.print("  ");
                }
                if (i != 0) {
                    System.out.print("   "+i);
                }
                if (i % this.size == 0 && i != 0) {
                    zeile++;
                }
            }
            else {
                if (i % (this.size+1) == 0) {
                    System.out.println();
                    System.out.print(zeile);
                    zeile++;
                    diff++;
                }
                else {
                    if (this.matrix.get(i-(this.size+diff)).getMarkiert()) {
                        System.out.print("   *");
                    }
                    else if (this.matrix.get(i-(this.size+diff)).getBombeAttribut()) {
                        System.out.print("   B");
                    }
                    else if (this.matrix.get(i-(this.size+diff)).getAufgedeckt()) {
                        System.out.print("   " + this.matrix.get(i-(this.size+diff)).getBenachbarteBomben());
                    }
                    else {
                        System.out.print("    ");
                    }
                }
            }
        }

    }

    public ArrayList<Zelle> getMatrix() {
        return this.matrix;
    }

    public ArrayList<Zelle> getBomben() {
        return this.bomben;
    }

    public int getSize() {
        return this.size;
    }

    public void schwierigkeitSetzen() {
        System.out.println("On which difficulty level do you want to play Minesweeper? hard [h], medium [m] or easy [e]");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String inputString = myObj.nextLine();
        if (inputString.equals("h")) {
            this.size = 100;
            this.wahrscheinlichkeit = 20;
        }
        else if (inputString.equals("m")) {
            this.size = 50;
            this.wahrscheinlichkeit = 10;
        }
        else if (inputString.equals("e")) {
            this.size = 10;
            this.wahrscheinlichkeit = 5;
        }
        else {
            this.size = 50;
            this.wahrscheinlichkeit = 10;
        }
    }
}
