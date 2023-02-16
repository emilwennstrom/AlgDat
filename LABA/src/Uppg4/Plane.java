package Uppg4;

public class Plane {

    private int waitTime;

    public Plane(){
        waitTime = 0;
    }

    public void addWaitTime(int min) {
        waitTime += min;
    }

    public int getWaitTime() {
        return waitTime;
    }

}
