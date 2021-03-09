package m226_1.minesweeper;

import m226_1.projekt_bank.Konto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpielmatrixTest {

    Spielmatrix sm;
    @BeforeEach
    void setUp() {
        sm = new Spielmatrix();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void zellenHinzufuegen() {
        sm.zellenHinzufuegen();
        assertEquals(sm.getSize(), 10);
    }
}