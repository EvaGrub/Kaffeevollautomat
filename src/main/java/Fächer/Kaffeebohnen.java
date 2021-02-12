package Fächer;

public class Kaffeebohnen {
    static double kaffeebohnen = 100;
    public static void kaffeebohnenAuffuellen() { kaffeebohnen = 100; }
    public static double getKaffeebohnen() {return kaffeebohnen;}
    public static void kaffeeReduzieren(double pBedarf) {
        kaffeebohnen -= pBedarf;
    }
}
