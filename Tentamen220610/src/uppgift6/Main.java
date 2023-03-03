package uppgift6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("./src/uppgift6/graf.txt"));
            //filen graf.txt ska ligga i packagemappen uppgift6 bredvid denna fil
            String[] numbers;
            String line;
            int nrOfNodes = Integer.parseInt(in.readLine());
            //deklarera graph som ska representera grafen
            while((line = in.readLine())!=null) {
                numbers = line.split(" +");
                int node1 = Integer.parseInt(numbers[0]);
                int node2 = Integer.parseInt(numbers[1]);
                int weight = Integer.parseInt(numbers[2]);
                //representera bågen i grafen, tänk på att man ska kunna gå från node1 till node2 och från node2 till node1
            }
            for(int i=0;i<nrOfNodes;i++) {
                for(int j=0;j<nrOfNodes;j++) {
                    //System.out.println("Kortaste vägen från " + i + " till " + j + ": " + travelTime(i, j, graph));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
