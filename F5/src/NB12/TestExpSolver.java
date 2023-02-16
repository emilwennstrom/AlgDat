package NB12;

public class TestExpSolver {

    public static void main(String[] args) {
        int x = 2;
        int n = 1;

        int res = ExponentialSolver.calcExpRecursive(x, n);
        System.out.println(res);

        res = ExponentialSolver.calcExpIterative(x, n);
        System.out.println(res);


    }
}
