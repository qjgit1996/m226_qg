package m226_1.minesweeper.utils;
import m226_1.minesweeper.Zelle;
import m226_1.minesweeper.Spielmatrix;

public class Matrixfilter {
    public Zelle[] matrixFiltern(Spielmatrix matrix, Zelle zelle) {
        Zelle[] dreierMatrix = matrix.getMatrix().stream().filter(e -> e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()-1 && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX() && e.getY() == zelle.getY()+1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()-1 ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY() ||
                e.getX() == zelle.getX()+1 && e.getY() == zelle.getY()+1).toArray(Zelle[]::new);
        return dreierMatrix;
    }
}
