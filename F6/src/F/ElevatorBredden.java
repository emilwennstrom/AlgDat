package F;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorBredden {

    private static class Tillstand {
        public int position, antalResor;

        public Tillstand(int p, int a) {
            position = p;
            antalResor = a;
        }
    }


    public static int antalResorBredd(int n, int upp, int ned, int destination) {
        Queue<Tillstand> queue = new LinkedList<>();
        Tillstand t = new Tillstand(1, 0);
        while(t.position != destination) {
            if (t.position + upp <= n) {
                queue.offer(new Tillstand(t.position + upp, t.antalResor + 1));
            }
            if (t.position - ned >= 1) {
                queue.offer(new Tillstand(t.position - ned, t.antalResor + 1));
            }
            t = queue.poll();
        }
        return t.antalResor;
    }

    public static void main(String[] args) {
        int n = antalResorBredd(78, 15, 8, 35);
        System.out.println(n);
    }



}
