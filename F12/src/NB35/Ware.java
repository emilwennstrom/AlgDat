package NB35;

import java.util.Comparator;

public class Ware {


     private int weight;
     private int value;


    public Ware(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public Ware() {
        this.weight = 0;
        this.value = 0;
    }

    public double getRatio() {
        return ((double) value) / weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public int compareTo(Ware o) {
        if (this.getRatio() == o.getRatio()) return 0;
        if (this.getRatio() < getRatio()) return -1;
        else return 1;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
