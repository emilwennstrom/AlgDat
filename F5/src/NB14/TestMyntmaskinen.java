package NB14;

import java.util.Scanner;

public class TestMyntmaskinen {

    public static void main(String[] args) {
        String answer = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Om 5 kr stoppas in ökar poängen med 4.");
        System.out.println("Om 10 kr stoppas in multipliceras poängen med 3");
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
