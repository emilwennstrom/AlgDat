package Uppg4;

import java.util.Random;

public class AirportMain {

    static final int MINUTES = (10 * 365 * 24 * (60/5));
    static final int DELAY = (20 / 5);

    public static void main(String[] args) {
        ArrayQueue<Plane> landingPlanes = new ArrayQueue<>(500);
        ArrayQueue<Plane> liftingPlanes = new ArrayQueue<>(500);
        Random random = new Random();

        int noOfStarts = 0;
        int noOfLandings = 0;

        int delay = 0;

        int landWait = 0;
        int liftWait = 0;

        int landWaitTot = 0;
        int liftWaitTot = 0;

        int longestLiftWait = 0;
        int longestLandWait = 0;

        for (int i = 0; i < MINUTES; i++) {
            if (delay <= 0) {
                if (landingPlanes.peek() != null) {
                    Plane p = landingPlanes.poll();
                    if (longestLandWait < p.getWaitTime())
                        longestLandWait = p.getWaitTime();
                    noOfLandings++;
                    landWaitTot += landWait;
                    landWait = 0;
                    delay = DELAY;
                } else if (liftingPlanes.peek() != null) {
                    Plane p = liftingPlanes.poll();
                    if (longestLiftWait < p.getWaitTime())
                        longestLiftWait = p.getWaitTime();
                    noOfStarts++;
                    liftWaitTot += liftWait;
                    liftWait = 0;
                    delay = DELAY;
                }
            }
            if (!landingPlanes.empty()){
                for (Plane p : landingPlanes)
                    p.addWaitTime(5);
                landWait += landingPlanes.size() * 5;
            }
            if(!liftingPlanes.empty()) {
                for (Plane p : liftingPlanes)
                    p.addWaitTime(5);
                liftWait += liftingPlanes.size() * 5;
            }
            int randomLand = random.nextInt(20);
            int randomLift = random.nextInt(20);
            if (i == 1) {
                landingPlanes.offer(new Plane());
            }
            if (i == 2) {
                liftingPlanes.offer(new Plane());
            }
            delay--;
        }

        double avgLandWait = (double) landWaitTot/noOfLandings;
        double avgLiftWait = (double) liftWaitTot/noOfStarts;

        System.out.println("Avg waiting time for landings: " + String.format("%.1f",avgLandWait) + " min.");

        System.out.println("Avg waiting time for take-offs " + String.format("%.1f", avgLiftWait) + " min.");

        System.out.println("Maximum wait time for a landing: " + longestLandWait + " min.");
        System.out.println("Maximum wait time for a take off: " + longestLiftWait + " min.");


    }
}
