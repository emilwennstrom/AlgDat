package NB35;

import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyKnapsack {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        PriorityQueue<Ware> wares = new PriorityQueue<>(new WareCompare());
        System.out.print("Enter size of knapsack: ");
        int knapSack;
        int noOfWares = 1;
        String check = "";
        String size = scan.nextLine();
        knapSack = Integer.parseInt(size);
        do {
            System.out.print("Enter value of ware no " + noOfWares + ": ");
            int value = scan.nextInt();
            System.out.print("Enter weight of ware no " + noOfWares++ + ": ");
            int weight = scan.nextInt();
            wares.add(new Ware(weight, value));
            System.out.print("Add more wares? y/n ");
            check = scan.next();
        } while (!check.equalsIgnoreCase("n"));

        int value = 0;
        while (!wares.isEmpty()) {
            Ware ware = wares.poll();
            while(ware.getWeight() <= knapSack) {
                knapSack -= ware.getWeight();
                value += ware.getValue();
            }
        }


        System.out.println("Value of knapsack : " + value);



    }



}
