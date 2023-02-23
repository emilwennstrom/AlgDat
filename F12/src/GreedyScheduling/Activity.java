package GreedyScheduling;

import java.sql.Time;
import java.sql.Timestamp;

public class Activity {

    private double start;
    private double end;

    public Activity(double start, double end) {
        this.start = start;
        this.end = end;
    }



    public double getActivityDuration() {
        return end - start;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Start: " + start + ", End: " + end;
    }
}
