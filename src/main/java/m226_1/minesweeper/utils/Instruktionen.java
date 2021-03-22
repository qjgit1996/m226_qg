package m226_1.minesweeper.utils;

public class Instruktionen {
    public void printErsteInstruktionen() {
        System.out.println();
        System.out.println("Where are the bombs?");
        System.out.println("1. Which field do you want to uncover? -> T Or mark maybe one as a bomb? -> M");
        System.out.println("2. Choose the x coordinate you want to check");
        System.out.println("3. Choose the y coordinate you want to check");
    }
    public void schwierigkeitsinstruktionen() {
        System.out.println("On which difficulty level do you want to play Minesweeper? hard [h], medium [m] or easy [e]");
    }
}
