package Fuppgifter;

public class TestLinkedStack {
    public static void main(String[] args) {
        testLinkedStack();
    }

    public static void testObjectStack(){
        LinkedStack<Object> objs = new LinkedStack<>();

        objs.push("Hello");
        System.out.println(objs.peek());
        objs.push(1);
        System.out.println(objs.peek());
        objs.push(20);
        System.out.println(objs.peek());

        Object[] o = new Object[10];
        o[0] = "Hej";
        o[2] = 1;
        o[1] = 10;


        System.out.println(o[0] +" "+ o[1] +" "+ o[2]);


    }

    public static void testLinkedStack(){
        LinkedStack<Integer> ints = new LinkedStack<>();
        int n = 5;
        System.out.print("Added: ");
        for (int i = 0; i < n; i++) {
            ints.push(i+1);
            System.out.print(ints.peek() + " ");
        }

        System.out.println("\n------------------------------------");

        System.out.println("Size: " + ints.size());
        System.out.print("Peek top down: ");
        for (int i = 0; i < ints.size(); i++){
            System.out.print(ints.peek(i) + " ");
        }

        System.out.print("\nPeek down up: ");
        for (int i = ints.size() - 1; i >= 0; i--){
            System.out.print(ints.peek(i) + " ");
        }

        System.out.println("\n------------------------------------");

        System.out.println("Stack empty, last element was: " + ints.flush());
        System.out.println("Stack size: " + ints.size());

        //ints.pop(); exc


    }


}
