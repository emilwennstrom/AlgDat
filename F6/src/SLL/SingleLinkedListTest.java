package SLL;

import java.util.Iterator;

public class SingleLinkedListTest {
    public static void main(String[] args) {

        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add("Sträng " + i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(list.getRec(i));
        }

        System.out.println(list.size());


    }
}