package m226_1.minesweeper;

import java.util.ArrayList;
import java.util.Random;

public class Spielmatrix {
    private ArrayList<Zelle> matrix = new ArrayList<>();
    private ArrayList<Zelle> bomben = new ArrayList<>();
    private int size;

    public Spielmatrix(int size) {
        this.matrix = matrix;
        this.bomben = bomben;
        this.size = size;
    }

    public void zellenHinzufuegen() {
        Random rnd = new Random();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                int x = i+1;
                int y = j+1;
                int wahlBombe = rnd.nextInt(10);
                if (wahlBombe == 5) {
                    Zelle zelle = new Zelle(x, y, true);
                    this.matrix.add(zelle);
                    this.bomben.add(zelle);
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
                    System.out.print(" ");
                }
                if (i != 0) {
                    System.out.print("  "+i);
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
                        System.out.print("  *");
                    }
                    else if (this.matrix.get(i-(this.size+diff)).getBombeAttribut()) {
                        System.out.print("  B");
                    }
                    else if (this.matrix.get(i-(this.size+diff)).getAufgedeckt()) {
                        System.out.print("  " + this.matrix.get(i-(this.size+diff)).getBenachbarteBomben());
                    }
                    else {
                        System.out.print("   ");
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
}
