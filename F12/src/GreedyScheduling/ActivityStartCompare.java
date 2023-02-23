package GreedyScheduling;

import java.util.Comparator;

public class ActivityStartCompare implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return Double.compare(o1.getStart(), o2.getStart());
    }
}
