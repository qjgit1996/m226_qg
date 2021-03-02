package m226_1.minesweeper;

import java.util.ArrayList;

public class Spielmatrix {
    private ArrayList<Zelle> matrix = new ArrayList<>();
    private int size;

    public Spielmatrix(int size) {
        this.matrix = matrix;
        this.size = size;
    }

    public void zellenHinzufuegen() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Zelle zelle = new Zelle(i, j);
                this.matrix.add(zelle);
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
                    if (this.matrix.get(i-(this.size+diff)).getAufgedeckt()) {
                        System.out.print("  1");
                    }
                    System.out.print("   ");
                }
            }
        }
    }

    public ArrayList<Zelle> getMatrix() {
        return this.matrix;
    }
}
