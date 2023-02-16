package Uppg2;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        testKod1();
    }

    public static void testKod1(){
        SingleLinkedList<String> l = new SingleLinkedList<>();
        for(int i =0; i<4; i++){
            l.add("e" + i);
        }
        l.remove(3);
        l.add(0,"first");
        l.add("sist");
        System.out.println(l);
    }

    public static void genTest() {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        for (int i = 0; i < 20;i++) {
            list.add(i, "S" + i);
        }


        System.out.println(list); // Skrive ut listan s0-s19
        System.out.println("Size:" + list.size());  // size = 20

        list.add(5, "-1");      // lägger till elementet -1 på index 5
        System.out.println("Size:" + list.size());  // size = 21

        System.out.println("Head: " + list.getFirst()); // head = s0
        System.out.println("Tail: " + list.getLast()); // tail = s19

        System.out.println(list); //

        System.out.println(list.get((list.size()) - 1));  // hämtar sista elementet (S19, tail)



        list.add(0, "-2");
        list.add(list.size(), "-3");

        System.out.println(list);

        System.out.println("Head: " + list.getFirst());
        System.out.println("Tail: " + list.getLast());

        list.remove(list.size() - 1);

        System.out.println(list);

        System.out.println("Head: " + list.getFirst());
        System.out.println("Tail: " + list.getLast());

        for (int i = 1; i <= 10; i++) {
            list.add(list.size(), "B" + i);
        }

        for (int i = 1; i <= 10; i++) {
            list.add(list.size() - 2, "C" + i);
        }




        System.out.println(list);
        System.out.println("Head: " + list.getFirst());
        System.out.println("Tail: " + list.getLast());

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.remove(i) + " ");
        }
        System.out.println("\n");

        System.out.println("Head " + list.getFirst());
        System.out.println("Tail " + list.getLast());

        System.out.println();



        for (int i = 0; i < 10; i++) {
            list.add(0, "String: " + i);
        }

        System.out.println(list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list.get(0));
        System.out.println(list.get(9));

    }

    public static void tailtest(){
        SingleLinkedList<Integer> is = new SingleLinkedList<>();
        for (int i = 0; i < 5; i++){
            is.add(i);
        }
        System.out.println(is);
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print(is.get(0) + " ");
            is.remove(0);
        }
        System.out.println();

        System.out.println("Tail: " + is.getFirst());
        System.out.println("Head: " + is.getLast());

        System.out.println();

        for (int i = 0; i < 5; i++){
            is.add(i);
        }

        System.out.println(is);
        System.out.println();

        System.out.println("Tail: " + is.getFirst());
        System.out.println("Head: " + is.getLast());

        for (int i = 0; i < 3; i++){
            is.remove(0);
        }

        System.out.println(is);
        System.out.println();
        System.out.println("Tail: " + is.getFirst());
        System.out.println("Head: " + is.getLast());


    }
}