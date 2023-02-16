package Uppg1;

public class Main {
    public static void main(String[] args) {

       for (int i = 1; i <= 20; i++) {
            System.out.print(numeriskAnalys(i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= 40; i++) {
            System.out.print(numeriskAnalys(i) + " ");
        }
        System.out.println();


        System.out.println(numeriskAnalys(100));
        //System.out.println(numeriskAnalys(200));
        int d = numeriskAnalys(40);
        int a = numeriskAnalys(100);
        int b = numeriskAnalys(200);

        double c = (double) b / a;

        System.out.println(a);
        System.out.println(d);
        System.out.println(c);




    }



    private static int numeriskAnalys(int n) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = j; k <= i + j; k++) {
                    for (int m = 1; m <= i + j - k; m++) {
                        r++;
                    }
                }
            }
        }
        return r;
    }
}