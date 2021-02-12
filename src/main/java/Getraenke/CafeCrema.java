package Getraenke;

public class CafeCrema {
    final static private double[][] mischverhaeltnis =  {{8, 2, 3, 4}, {10, 3, 4, 5}, {20, 6, 8, 10}};
    public static double[] gibMischverhaeltnis(int pTassengroesse, int pKaffestaerke) {
        return new double[]{mischverhaeltnis[ pTassengroesse][0], mischverhaeltnis[ pTassengroesse][ pKaffestaerke]};
    }
}
