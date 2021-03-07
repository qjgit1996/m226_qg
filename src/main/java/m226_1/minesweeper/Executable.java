package m226_1.minesweeper;

/**
 * Diese Klasse wird als erstes initiert und dient als Ausführungsklasse. Sie sorgt dafür,
 * dass nacheinander die richtigen Klassen und Methoden ausgeführt werden, damit das Spiel
 * richtig funktioniert.
 * @author Quinten Groenveld
 * @version 1.1
 */
public class Executable {
    public static void main(String[] args) {
        Spielmatrix spielmatrix = new Spielmatrix();
        spielmatrix.schwierigkeitSetzen();
        spielmatrix.zellenHinzufuegen();
        SpielEngine engine = new SpielEngine(spielmatrix);
        engine.start();
    }
}
