package m226_1.minesweeper;

import java.util.ArrayList;

public class Executable {
    public void main(String[] args) {
        matrixErstellung();
    }

    public void matrixErstellung() {
        int sizeMatrix = 10;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                Zelle zelle = new Zelle(i, j);

            }

        }
    }
}
