package NB8;

public class TestArrayQueue {

    public static void main(String[] args) {
        ArrayQueue<Integer> ints = new ArrayQueue<>(20);

        for (int i = 0; i < 40; i++) {
            ints.offer(i);
        }

        for (int i = 0; i < 30; i++) {
            ints.poll();
        }


    }
}
