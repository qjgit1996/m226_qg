package m226_1.minesweeper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZelleTest {

    Zelle z;
    Zelle z1;
    @BeforeEach
    void setUp() {
        z = new Zelle(3,4,true);
        z1 = new Zelle(5,7,false);

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void markiertAendern() {
        z1.markiertAendern();
        assertEquals(z1.getAufgedeckt(), false);
    }

    @Test
    void aufgedecktAendern() {
        z.aufgedecktAendern();
        assertEquals(z.getAufgedeckt(), true);
    }

    @Test
    void getBombeAttributTrue() {
        assertEquals(z.getBombeAttribut(), true);
    }

    @Test
    void getBombeAttributFalse() {
        assertEquals(z1.getBombeAttribut(), false);
    }
}