package m226_1.minesweeper;

/**
 * Diese Klasse stellt die Zelle innerhalb von Minesweeper dar.
 * @author Quinten Groenveld
 * @version 1.1
 */

public class Zelle {
    private boolean aufgedeckt = false;
    private boolean markiert = false;
    private int xPosition;
    private int yPosition;
    private boolean istBombe;
    private boolean gezaehlt;
    private boolean iteriert;
    private int benachbarteBomben = 0;

    /**
     * Konstruktor für die Zelle.
     * @param xPosition X-Koordinate im Spielfeld.
     * @param yPosition Y-Koordinate im Spielfeld.
     * @param istBombe Variable, welche aussagt, ob die Zelle eine Bombe ist oder nicht.
     */
    public Zelle(int xPosition, int yPosition, boolean istBombe) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.istBombe = istBombe;
        this.gezaehlt = false;
        this.iteriert = false;
    }

    /**
     * Getter Methode um herauszufinden, ob die Zelle schon aufgedeckt ist oder nicht.
     * @return Gibt einen Boolean zurück. True = aufgedeckt, false = nicht aufgedeckt.
     */
    public boolean getAufgedeckt() {
        return this.aufgedeckt;
    }

    /**
     * Getter Methode um herauszufinden, ob die Zelle schon markiert ist oder nicht.
     * @return Gibt einen Boolean zurück. True = markiert, false = nicht markiert.
     */
    public boolean getMarkiert() {
        return this.markiert;
    }

    /**
     * Ändert die Markierung von false auf true.
     */
    public void markiertAendern() {
        if (!this.markiert) {
            this.markiert = true;
        }
        else {
            this.markiert = false;
        }
    }

    /**
     * Ändert die Aufdeckung von false auf true und ändert die Markierung von true auf false,
     * wenn die Zelle vorher markiert war.
     */
    public void aufgedecktAendern() {
        if (!this.aufgedeckt) {
            this.aufgedeckt = true;
            if (this.markiert) {
                this.markiert = false;
            }
        }
        else {
            this.aufgedeckt = true;
        }
    }

    /**
     * Getter Methode um die X-Koordinate herauszufinden.
     * @return X-Koordinate der Zelle.
     */
    public int getX() {
        return this.xPosition;
    }

    /**
     * Getter Methode um die Y-Koordinate herauszufinden.
     * @return Y-Koordinate der Zelle.
     */
    public int getY() {
        return this.yPosition;
    }

    /**
     * Getter Methode um herauszufinden, ob die Zelle eine Bombe ist oder nicht.
     * @return Gibt einen Boolean zurück. True = Bombe, false = keine Bombe.
     */
    public boolean getBombeAttribut() {return this.istBombe;}

    /**
     * Erhöht das Attribut der Zelle, welche aussagt wie viele Bomben es um sich hat, um eins.
     */
    public void setBenachbarteBomben() {
        this.benachbarteBomben++;
    }

    /**
     * Getter Methode um herauszufinden, wie viele Bomben um eine Zelle herum sind.
     * @return Gibt ein Integer mit der berechneten Anzahl benachbarten Bomben um der Zelle zurück.
     */
    public int getBenachbarteBomben() {
        return this.benachbarteBomben;
    }

    public boolean getGezaehlt() {
        return this.gezaehlt;
    }

    public void setGezaehlt() {
        this.gezaehlt = true;
    }

    public boolean getIteriert() {
        return this.iteriert;
    }

    public void setIteriert() {
        this.iteriert = true;
    }
}
