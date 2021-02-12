import Fächer.Kaffeebohnen;
import Fächer.Wasserbehaelter;
import Getraenke.CafeCrema;
import Getraenke.Espresso;
import Getraenke.Wasser;

public class Pruefung {
    double[] bedarf = {0,0};
    double wasserbedarf, kaffeebedarf;
    boolean wasserReicht, kaffeeReicht;
    public Pruefung() {
        switch (ProgrammWahl.getraenk) {
            case HEISSES_WASSER -> bedarf[0] = Wasser.gibWassermenge(ProgrammWahl.tassengroesse);
            case CAFE_CREMA -> bedarf = CafeCrema.gibMischverhaeltnis(ProgrammWahl.tassengroesse, ProgrammWahl.kaffestaerke);
            case ESPRESSO -> bedarf = Espresso.gibMischverhaeltnis(ProgrammWahl.tassengroesse, ProgrammWahl.kaffestaerke);
        }
        wasserbedarf = bedarf[0];
        kaffeebedarf = bedarf[1];
        wasserReicht = genugWasserVorhanden();
        kaffeeReicht = genugKaffeepulver();
    }

    private boolean genugWasserVorhanden() {
        return bedarf[0] <= Wasserbehaelter.getWasserstand();
    }

    private boolean genugKaffeepulver() {
        return bedarf[1] <= Kaffeebohnen.getKaffeebohnen();
    }
}
