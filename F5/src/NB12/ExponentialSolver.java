package NB12;

public class ExponentialSolver {

    public static int calcExpRecursive(int x, int n) {
        if (n < 1) return 1;
        return calcExp(x, x, n);
    }

    private static int calcExp(int x, int multiplier, int n) {
        if (n > 1) return calcExp(x * multiplier, multiplier, n - 1);
        return x;
    }

    public static int calcExpIterative(int x, int n) {
        if (n < 1) return 1;
        int result = x;
        for (int i = n; i > 1; i--) {
            result = x * result;
        }
        return result;
    }

}
