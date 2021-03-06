package m226_1.minesweeper;

public class Executable {
    public static void main(String[] args) {
        Spielmatrix spielmatrix = new Spielmatrix();
        spielmatrix.schwierigkeitSetzen();
        spielmatrix.zellenHinzufuegen();
        SpielEngine engine = new SpielEngine(spielmatrix);
        engine.start();

    }
}
