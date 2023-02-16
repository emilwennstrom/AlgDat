package F;

public class Fakultet {
    public static void main(String[] args) {
        System.out.println(rekFak(10));
    }

    static int rekFak(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * rekFak(n - 1);
        }
    }

    /* n = 5
        return 5 * rekFak(5-1) --> 5 * 3 * 2 * 1 * 1
       n = 4
         return 4 * rekFak(4-1) --> 4 * 3 * 2 * 1 * 1
       n = 3
         return 3 * rekFak(3-1) --> 3 * 2 * 1 * 1
       n = 2
         return 2 * rekFak(2-1) --> 2 * 1 * 1
       n = 1
         return 1 * rekFak(1-1) --> 1 * 1
       n = 0
         return 1

      */
}
