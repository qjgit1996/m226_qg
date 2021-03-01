package m226_1.minesweeper;

public class Zelle {
    private boolean aufgedeckt = false;
    private boolean markiert = false;
    private int xPosition;
    private int yPosition;
    private boolean istBombe;
    public Zelle(int xPosition, int yPosition) {
        this.aufgedeckt = aufgedeckt;
        this.markiert = markiert;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public boolean getAufgedeckt() {
        return this.aufgedeckt;
    }
}
