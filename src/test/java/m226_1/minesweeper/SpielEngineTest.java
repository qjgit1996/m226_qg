package m226_1.minesweeper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpielEngineTest {

    SpielEngine se;
    @BeforeEach
    void setUp() {
        Spielmatrix sm = new Spielmatrix();
        se = new SpielEngine(sm);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void dreierMatrixAlgorithmusV2Standard() {
        Zelle z = new Zelle(3,4,false);
        se.dreierMatrixAlgorithmusV2(z);
        assertEquals(z.getIteriert(), false);
    }

    @Test
    void dreierMatrixAlgorithmusV2NegativeKoordinaten() {
        Zelle z = new Zelle(-3,-4,false);
        se.dreierMatrixAlgorithmusV2(z);
        assertEquals(z.getBenachbarteBomben(), 0);
    }

    @Test
    void dreierMatrixAlgorithmusV2NullerKoordinaten() {
        Zelle z = new Zelle(0,0,false);
        se.dreierMatrixAlgorithmusV2(z);
        assertEquals(z.getAufgedeckt(), true);
    }
}