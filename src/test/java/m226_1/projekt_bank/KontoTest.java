package m226_1.projekt_bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto k;

    @BeforeEach
    void setUp() {
        // vor jedem Test wird das Konto neu instantiiert.
        k = new Konto(100, 0.01);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getSaldo() {
        assertEquals(k.getSaldo(), 100);
    }

    @Test
    void einzahlenStandardFall() {
        k.einzahlen(100);
        assertEquals(k.getSaldo(), 200);
    }

    @Test
    void einzahlenNegativeZahlen() {
        k.einzahlen(-100);
        assertEquals(k.getSaldo(), 100);
    }

    @Test
    void einzahlenNull() {
        k.einzahlen(0);
        assertEquals(k.getSaldo(), 100);
    }


    @Test
    void abhebenStandardFall() {
        k.abheben(50);
        assertEquals(k.getSaldo(), 48);
    }

    @Test
    void abhebenNegativeZahlen() {
        k.abheben(-50);
        assertEquals(k.getSaldo(), 100);
    }

    @Test
    void abhebenNull() {
        k.abheben(0);
        assertEquals(k.getSaldo(), 100);
    }

    @Test
    void verzinsenStandard() {
        k.verzinsen(365);
        assertEquals(k.getSaldo(), 101);
    }

    @Test
    void verzinsenNegativ() {
        k.verzinsen(-365);
        assertEquals(k.getSaldo(), 100);
    }

    @Test
    void verzinsenNull() {
        k.verzinsen(0);
        assertEquals(k.getSaldo(), 100);
    }
}