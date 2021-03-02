package m226_1.minesweeper;

public class Zelle {
    private boolean aufgedeckt = false;
    private boolean markiert = false;
    private int xPosition;
    private int yPosition;
    private boolean istBombe;
    public Zelle(int xPosition, int yPosition, boolean istbombe) {
        this.aufgedeckt = aufgedeckt;
        this.markiert = markiert;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.istBombe = istBombe;
    }

    public boolean getAufgedeckt() {
        return this.aufgedeckt;
    }
    public boolean getMarkiert() {
        return this.markiert;
    }

    public void markiertAendern() {
        if (this.markiert == false) {
            this.markiert = true;
        }
        else {
            this.markiert = false;
        }
    }

    public void aufgedecktAendern() {
        if (this.aufgedeckt == false) {
            this.aufgedeckt = true;
        }
        else {
            this.aufgedeckt = false;
        }
    }

    public int getX() {
        return this.xPosition;
    }

    public int getY() {
        return this.yPosition;
    }

    public boolean getBombeAttribut() {return this.istBombe;}
}
