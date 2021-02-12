package Fächer;

public class Kaffeesatz {
    static int zZaehler = 0;

    public static void kaffeesatzLeeren() {zZaehler = 0;}
    public static boolean kaffesatzIstVoll() { return zZaehler > 15;}
    public static void kaffeesatzFuellen() {zZaehler++;}

}
