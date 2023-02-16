package NB11;

public class TestBiggestInt {

    public static void main(String[] args) {
        int[] ints = {300};
        int big = BiggestInt.getBiggestInt(ints);

        ints = new int[]{300, 500};
        big = BiggestInt.getBiggestInt(ints);

        ints = new int[]{300, 500, 100, 50, 400, 500, 600};
        big = BiggestInt.getBiggestInt(ints);

        System.out.println(big);
    }
}
