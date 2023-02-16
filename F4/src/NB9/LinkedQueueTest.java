package NB9;

public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> ints = new LinkedQueue<>();

        for (int i = 0; i < 200; i++) {
            ints.enqueue(i + 1); // köar 1-200
        }
        System.out.println(ints.size()); // size == 200

        for (int i = 0; i < 100; i++) {
            System.out.print(ints.dequeue() + " "); //avköar 1-100
        }
        System.out.println();
        System.out.println(ints.size()); // size == 100

        System.out.println(ints.dequeue()); // 101

        for (int i = 0; i < 100; i++) {
            System.out.print(ints.dequeue() + " "); //102 - 200 + null
        }

        for (int i = 0; i < 200; i++) {
            ints.enqueue(i + 1); // köar 1-200
        }
        System.out.println();

        System.out.println(ints.size());



    }
}
