package NB81;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> ints = new ArrayQueue<>(10);

        for (int i = 0; i < 5; i++) {   // rear pekar på fel element, ändrar rear till max - 1 och flyttar om i offer
            ints.offer(i);
        }
        System.out.println(ints);

        for (int i = 0; i < 10; i++) { // testar att lägga till mer än 10, reallocate fungerar inte. skriver om den.
            ints.offer(i);
        }

        System.out.println(ints);

        System.out.println(ints.peek());

        for (int i = 0; i < 5; i++) {
            System.out.print(ints.poll() + " ");
        }
        System.out.println();

        System.out.println(ints);


        for (int i = 0; i < 10; i++) {
            ints.offer(i); // Gav ArrayOutOfbounds, var tvungen att lägga på parenteser i offer
        }

        System.out.println(ints);

        for (int i = 0; i < 20; i++) {
            ints.poll(); // gav outofbounds i poll, fattades parenteser
        }

        System.out.println(ints);



    }
}
