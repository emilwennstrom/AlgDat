import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BogoRandSort {




   public static void main(String[] args) {
       double counter = 0;
       ArrayList<Integer> ints = new ArrayList<>();
       Random random = new Random();
       for (int i = 0; i < 13; i++) {
           ints.add(random.nextInt(0, 130));
       }
        double a = System.currentTimeMillis();
       while (!checkSort(ints)) {
           counter = counter + 0.1;
           Collections.shuffle(ints);
       }
       double b = System.currentTimeMillis();



       System.out.println(ints);
       System.out.println("time: " + (b - a));
       System.out.println("loops: " + counter);
   }


   public static boolean checkSort(ArrayList<Integer> ints) {
       for (int i = 0; i < ints.size() - 1; i++) {
           if (ints.get(i) > ints.get(i + 1)) {
               return false;
           }
       }
       return true;
   }

}
