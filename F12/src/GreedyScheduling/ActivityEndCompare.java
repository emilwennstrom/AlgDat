package GreedyScheduling;

import java.util.Comparator;

public class ActivityEndCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return Double.compare(o2.getEnd(), o1.getEnd());
    }

}
