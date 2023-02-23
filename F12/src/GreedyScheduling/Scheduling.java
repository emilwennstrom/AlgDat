package GreedyScheduling;

import java.util.*;

public class Scheduling {


    public static void main(String[] args) {

        Random random = new Random();
        double randStart;
        double randEnd;

        LinkedList<Activity> activities = new LinkedList<>();
        PriorityQueue<Activity> schedule = new PriorityQueue<>(new ActivityEndCompare());

        for (int i = 0; i < 10; i++) {
            randStart = random.nextDouble(6, 22);
            randEnd = random.nextDouble(6, 22);
            if (randEnd < randStart) {
                double tmp = randEnd;
                randEnd = randStart;
                randStart = tmp;
            }
            activities.add(new Activity(randStart, randEnd));
        }
        activities.sort(new ActivityStartCompare());
        schedule.add(activities.poll());
        while (activities.peek() != null) {
            Activity a = schedule.peek();
            Activity b = activities.peek();
            if (a != null && b != null && a.getEnd() > b.getStart()) {
                activities.remove();
            } else {
                schedule.add(activities.poll());
            }
        }

        while (!schedule.isEmpty()) {
            System.out.println(schedule.poll());
        }

    }


}
