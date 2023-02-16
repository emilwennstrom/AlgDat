package F;

import java.util.Scanner;

public class WordMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BinarySearchTree<String> stringBin = new BinarySearchTree<>();

        // Ord för minsta djup: dörr, citron, eld, apa, banan, fisk, grön

        // ord för maximalt djup: apa, banan, citron, dörr, eld, fisk, grön



        for (int i = 0; i < 7; i++) {
            System.out.print("Skriv ett ord: ");
            String in = scan.nextLine();
            stringBin.add(in);
        }

        System.out.println(stringBin);



    }
}
