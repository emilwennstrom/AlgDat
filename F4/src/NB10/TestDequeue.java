package NB10;

public class TestDequeue {
    public static void main(String[] args) {
        Dequeue<Character> c = new Dequeue<>();

        c.offerFirst('a'); // först: a
        c.offerFirst('b'); // först: b a
        c.offerLast('c'); // sist: b a c
        c.offerFirst('d'); // först d b a c

        System.out.println(c.pollLast()); // skriver ut c ---> sist d b a
        System.out.println(c.pollFirst()); // skriver ut d ---> b a

        c.offerFirst('e'); // e b a
        System.out.println(c.pollLast()); // skriver ut a ---> e b
        System.out.println(c.pollLast()); // skriver ut b
        System.out.println(c.pollLast()); // skriver ut e

        Dequeue<Integer> ints = new Dequeue<>();

        for (int i = 0; i < 50; i++) {
            ints.offerFirst(i+1);
        }

        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.print(ints.pollFirst() + " ");
            }
            else System.out.println(ints.pollLast() + " ");
        }








    }
}
