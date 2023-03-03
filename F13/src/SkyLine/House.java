package SkyLine;

public class House implements Comparable<House> {
    private int x1, y, x2;


    public House(int x1, int y, int x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }


    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }


    public String toString() {
        return "x1: " + x1 + " x2: " + x2 + " y: " + y;
    }


    @Override
    public int compareTo(House o) {
        if (this.x1 == o.x1) {
            if (this.x2 == o.x2) {
                if (this.y == o.y) return 0;
                else if (this.y > o.y) return -1;
                return 1;
            } else if (this.x2 < o.x2)
                return -1;
            return 1;
        }
        else if(this.x1 < o.x1) return -1;
        return 1;
    }
}
