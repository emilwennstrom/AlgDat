package NB27;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;

public class CarMain {
    public static void main(String[] args) throws IOException {
        CarUtils carUtils = CarUtils.createUtils();

        Car[] cars = new Car[10];
        for (int i = 0; i < cars.length; i++) {
            Car car = new Car(carUtils.randomModel(), carUtils.randomModelYear(), carUtils.randomMileage());
            cars[i] = car;
        }
        carUtils.writeCarsToFile(cars, "unsortedCars");     // skriver osorterade bilar till textfil
        cars = carUtils.getCarsFromFile(cars.length, "unsortedCars");       // hämtar textfilen

        Arrays.sort(cars); // Sorterar med modellnamn
        carUtils.writeCarsToFile(cars, "sortedByName"); // Skriver sorterade efter modellnamn
        Car[] sortedByNames = carUtils.getCarsFromFile(cars.length, "sortedByName");    // hämtar dessa

        for (Car c : sortedByNames) { // skriver ut
            System.out.println(c);
        }
        System.out.println();

        Arrays.sort(cars, new CompareCar()); // sorterar med årsmodell

        carUtils.writeCarsToFile(cars, "sortedByAge"); // skriver årsmodell till fil
        Car[] sortedByAge = carUtils.getCarsFromFile(cars.length, "sortedByAge");   // hämtar

        for (Car c : sortedByAge) { // skriver ut
            System.out.println(c);
        }
        System.out.println();






    }
}
