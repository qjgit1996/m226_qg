package m226_1.minesweeper;

import java.util.ArrayList;

public class Spielmatrix {
    private ArrayList<Zelle> matrix = new ArrayList<>();
    private int size;

    public Spielmatrix(int size) {
        this.matrix = matrix;
        this.size = size;
    }

    public void zelleHinzufuegen() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                Zelle zelle = new Zelle(i, j);
                this.matrix.add(zelle);
            }
        }
    }

    public void matrixAusgeben() {
        int zeile = 0;
        for (int i = 0; i < this.matrix.size(); i++) {
            if (zeile == 0) {
                System.out.println("1");
            }
            if (i%this.size == 0 && this.matrix.get(i).getAufgedeckt() == false)
            System.out.print(" ");
        }
    }
}
