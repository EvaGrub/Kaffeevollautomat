package Getraenke;

public class Wasser {
    final private static double[] wassermenge = {8, 10, 20};
    public static double gibWassermenge(int pTassengroesse) {
        return wassermenge[pTassengroesse];
    }
}
