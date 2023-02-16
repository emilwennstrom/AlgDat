package Uppg3;

import java.util.Iterator;

public class IteratorMethodsTest {
    public static void main(String[] args) {
        testkod2();
    }

    public static void testkod1() {
        IteratorMethods<Integer> test = new IteratorMethods<>();

        for (int i = 0; i < 10; i ++) {
            test.add(i+1);
        }

        System.out.println(test);

        Iterator<Integer> iter = test.iterator();

        System.out.print(iter.next()); // 1
        iter.remove();                   // ta bort 1
        System.out.println(" tas bort");
        System.out.println(test);
        System.out.print(iter.next()); // 2
        iter.remove();                   // ta bort 2
        System.out.println(" tas bort");
        System.out.println(test);
        System.out.println(iter.next()); // 3
        System.out.print(iter.next()); // 4
        iter.remove();                   // ta bort 4
        System.out.println(" tas bort");
        System.out.println(test);
        System.out.println(iter.next()); // 5
        System.out.println(iter.next()); // 6
        System.out.println(iter.next()); // 7
        System.out.print(iter.next()); // 8
        iter.remove();                   // ta bort 8
        System.out.println(" tas bort");
        System.out.println(test);
        System.out.print(iter.next()); // 9
        iter.remove();                   // ta bort 9
        System.out.println(" tas bort");
        System.out.println(test);
        System.out.print(iter.next()); // 10
        iter.remove();                   // ta bort 10
        System.out.println(" tas bort");
        System.out.println(test);



        iter = test.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            iter.remove();
        }

        System.out.println(test);

        for (int i = 0; i < 50; i++) {
            test.add(i);
        }

        System.out.println(test);

        iter = test.iterator();

        for (int i = 0; i < 5; i++) {
            System.out.println(iter.next());
            iter.remove();
        }

        System.out.println(test);

        for (int i = 0; i < 5; i++) {
            System.out.println(iter.next());
            iter.remove();
        }

        System.out.println(test);

        for (int i = 0; i < 10; i++) {
            iter.next();
        }
        System.out.println(iter.next());
        iter.remove();

        System.out.println(test);

        System.out.println();
    }

    public static void testkod2(){
        IteratorMethods<String> l = new IteratorMethods<>();
        for(int i =0; i<4; i++){
            l.add("e" + i);
        }
        Iterator<String> iter = l.iterator();
        //iter.remove(); //exception
        //iter.remove(); //exception
        iter.remove();
        System.out.println(l);
    }
}