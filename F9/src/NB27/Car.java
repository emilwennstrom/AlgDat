package NB27;

public class Car implements Comparable<Car>{

    private String model;
    private int modelYear;
    private int kilometers;


    public Car(String model, int modelYear, int kilometers) {
        this.model = model;
        this.modelYear = modelYear;
        this.kilometers = kilometers;
    }

    public Car(){
        this.model = "";
        this.modelYear = -1;
        this.kilometers = -1;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Override
    public int compareTo(Car o) {
        return this.model.compareTo(o.model);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Model: ").append(model).append(", ");
        sb.append("Model Year: ").append(modelYear).append(", ");
        sb.append("Kilometers: ").append(kilometers);
        return sb.toString();
    }
}
