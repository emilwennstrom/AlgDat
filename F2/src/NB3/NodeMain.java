package NB3;

import java.util.LinkedList;

public class NodeMain {

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.data = "Gilgamesh";
        node1.next = node2;

        node2.data = "löper";
        node2.next = node3;

        node3.data = "på";
        node3.next = node4;

        node4.data = "stäppen";
        node4.next = null;

        Node p = node1;


        while(p != null) {
            if (p.data.equals("löper")) {
                node2.next = node4;
                node3.next = null;
            }

            System.out.println(p.data);
            p = p.next;
        }

        /*while(p != null) {
            if (p.next != null && p.next.data.equals("på")) {
                node2.next = node4;
            }

            System.out.println(p.data);
            p = p.next;
        }*/

        System.out.println();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();

        node4.next = node5;

        node5.data = "och";
        node5.next = node6;
        node6.data = "tycker";
        node6.next = node7;
        node7.data = "om";
        node7.next = node8;
        node8.data = "det.";
        node8.next = null;

        p = node1;

        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }

        node6.next = null;

        p = node1;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

}
