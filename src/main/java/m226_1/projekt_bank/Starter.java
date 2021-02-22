package m226_1.projekt_bank;
import m226_1.projekt_bank.Konto;

import java.util.ArrayList;

public class Starter {
    public static void main(String[] args) {

        Kunde max = new Kunde("Max", "Müller", 1234);
        Konto k = new Konto(2, 2, max);
        Konto m = new Konto(234, 1.4);
        ArrayList<Konto> konten = new ArrayList<Konto>();
        k.einzahlen(500.75);
        k.verzinsen(365);
        m.einzahlen(720.50);
        m.verzinsen(750);
        konten.add(k);
        konten.add(m);

        System.out.println(k.toString());
    }
}