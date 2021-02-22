package m226_1.projekt_bank;

public class Kunde {
    private String name, vorname;
    private int kundenummer;

    public Kunde(String name, String vorname, int kundenummer) {
        this.name = name;
        this.vorname = vorname;
        this.kundenummer = kundenummer;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", kundenummer=" + kundenummer +
                '}';
    }
}
