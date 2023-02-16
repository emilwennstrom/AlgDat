package F;

public class Svansrekursivt {

    public static void main(String[] args) {
        System.out.println(fib(3));
    }


    static int fib(int n) {
        return fn(1, 1, 3, n);
    }

    static int fn(int fnMinus1, int fnMinus2, int n, int nFinal) {
        if (n == nFinal) {
            return fnMinus1+fnMinus2;
        } else {
            return fn(fnMinus1+fnMinus2
                    , fnMinus1, n+1, nFinal);
        }
    }

}
