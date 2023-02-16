package F;

public class TornetIHanoi {
    /**
     *
     * @param n antal brickor
     * @param pin1 pinne 1
     * @param pin2 pinne 2
     * @param pin3 pinne x
     */
    static void hanoi(int n, int pin1, int pin2, int pin3) {
        if (n > 0) {
            hanoi(n-1, pin1, pin3, pin2);
            System.out.println(pin1 + " -> " + pin2);
            hanoi(n - 1, pin3, pin2, pin1);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 1, 2, 3);
    }

}
