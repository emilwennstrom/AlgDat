package SLL;

import java.util.Iterator;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add("Sträng " + i);
        }
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println(list.toStringRec());

        System.out.println(list);

    }
}