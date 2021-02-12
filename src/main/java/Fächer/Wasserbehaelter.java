package Fächer;

public class Wasserbehaelter {
    static double wasserstand = 100;
    public static void wasserbehaelterFuellen() { wasserstand = 100; }
    public static double getWasserstand() {return wasserstand;}
    public static void wasserReduzieren(double pBedarf) {
        wasserstand -= pBedarf;
    }
}
