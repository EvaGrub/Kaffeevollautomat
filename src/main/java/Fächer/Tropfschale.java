package Fächer;

public class Tropfschale {
    static int zZaehler = 0;

    public static void tropfschaleFuellen() {
        zZaehler++;
    }

    public static boolean tropfschaleIstVoll() {
        return zZaehler >= 10;
    }

    public static void tropfschaleLeeren() { zZaehler = 0; }
}
