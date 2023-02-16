package NB141;

import static NB141.Kulor.beads;

public class TestKulor {
    public static void main(String[] args) {
        System.out.println(beads(2, 5,0));
        System.out.println(beads(1, 0,1));
        System.out.println(beads(2, 1,0));
        System.out.println(beads(3, 2,1));
        System.out.println(beads(5, 2,1));
        System.out.println(beads(5, 1,3));
    }
}