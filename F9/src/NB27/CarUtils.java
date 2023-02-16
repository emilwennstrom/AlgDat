package NB27;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CarUtils {
    private static CarUtils utils = null;
    private final ArrayList<String> carModels;
    private final Random rand;


    private CarUtils() {
        rand = new Random();
        carModels = new ArrayList<>();
        carModels.add("Audi");
        carModels.add("BMW");
        carModels.add("Citroën");
        carModels.add("Fiat");
        carModels.add("Honda");
        carModels.add("Wolkswagen");
        carModels.add("Mazda");
    }

    public void addModel(String model) {
        carModels.add(model);
    }

    public static CarUtils createUtils() {
        if (utils == null) {
            utils = new CarUtils();
        }
        return utils;
    }


    public String randomModel() {
        int randInt = rand.nextInt(0, carModels.size());
        return carModels.get(randInt);
    }


    public int randomMileage() {
        return rand.nextInt(1000, 300000);
    }

    public int randomModelYear() {
        return rand.nextInt(1980, 2023);
    }


    public void writeCarsToFile(Car[] cars, String fileName) throws IOException {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
           fileWriter = new FileWriter(fileName);
           printWriter = new PrintWriter(fileWriter);
           for (Car c : cars) {
               printWriter.println(c.getModel());
               printWriter.println(c.getModelYear());
               printWriter.println(c.getKilometers());
           }
        } catch (IOException e){
            throw new IOException();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
            if (printWriter != null)
                printWriter.close();
        }
    }


    public Car[] getCarsFromFile(int size, String fileName) throws FileNotFoundException {
        File file = null;
        Scanner scanner = null;
        Car[] cars = new Car[size];
        int i = 0;
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNext()){
                Car car = new Car();
                car.setModel(scanner.nextLine());
                car.setModelYear(Integer.parseInt(scanner.nextLine()));
                car.setKilometers(Integer.parseInt(scanner.nextLine()));
                cars[i++] = car;
            }
        } catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return cars;
    }




}
