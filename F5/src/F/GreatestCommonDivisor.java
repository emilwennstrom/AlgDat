package F;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int gcd = gcd(17, 13);
        System.out.println(gcd);

    }


    public static int gcd(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        return euklides(m, n);
    }

    public static int euklides(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

}
