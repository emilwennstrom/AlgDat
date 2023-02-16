package NB5;

public class TestArrayListStack {
    public static void main(String[] args) {
        ArrayListStack<Integer> ints = new ArrayListStack<>();

        System.out.println(ints.empty()); // true
        //System.out.println(ints.peek()); // exception

        for (int i = 0; i < 10; i++) {
            ints.push(i+1);
            System.out.println(ints.peek());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(ints.pop());
            System.out.println(ints.empty());
        }

        //ints.pop(); // exception


    }
}
