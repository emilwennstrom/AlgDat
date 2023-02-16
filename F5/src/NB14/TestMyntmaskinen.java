package NB14;

import java.util.Scanner;

public class TestMyntmaskinen {

    public static void main(String[] args) {
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Vilken poäng ska uppnås (enter för att avsluta): ");
            answer = scanner.nextLine();
            if (answer.equals("")) break;
            try {
                int money = Myntmaskinen.scoreCounter(Integer.parseInt(answer));
                if (money == Integer.MAX_VALUE) {
                    System.out.println("Poängen kan inte nås");
                } else {
                    System.out.println("Poängen kan nås med " + money + " kronor");
                }
            } catch (NumberFormatException e){
                System.out.println("Fel input");
            }

        }
    }

}
