package NB13;

public class RootSolver {



    public static double ROT(double n) {
        double a = 1;
        double e = 0.01;
        return ROT(n, a, e);
    }

    private static double ROT(double n, double a, double e) {
        if (Math.abs((a * a) - n) < e) {
            return a;
        }
        return ROT(n, ((a * a) + n) / (2 * a), e);
    }

}


