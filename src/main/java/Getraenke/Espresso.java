package Getraenke;

public class Espresso {
    final private static double[][] mischverhaeltnis =  {{2, 2, 3, 4}, {3, 3, 4, 5}, {6, 6, 8, 10}};
    public static double[] gibMischverhaeltnis(int pTassengroesse, int pKaffestaerke) {
        return new double[]{mischverhaeltnis[pTassengroesse][0], mischverhaeltnis[pTassengroesse][pKaffestaerke]};
    }
}
