package F;

public class NumberOfRoads {

    int left = 6; // n
    int down = 5; // m

    static int i = 0;





    public static void main(String [] args) throws InterruptedException {
        System.out.println(antalVagar(2, 3));
    }

    public static int antalVagar(int left, int down) throws InterruptedException {
        //Thread.sleep(1000);
        if (down == 0 && left == 0) {
            System.out.println("Left&Down = 0, return 1");
            return 1;
        }
        else {
            int noOfPaths = 0;
            if (left > 0) {
                System.out.println("In left > 0:: Left: " + left + " Down: " + down);
                noOfPaths = antalVagar(left - 1, down);
            } if (down > 0) {
                System.out.println("In down > 0:: Left: " + left + " Down: " + down);
                noOfPaths = noOfPaths + antalVagar(left, down - 1);
                System.out.println("NoOfPaths " + i++ + ": " + noOfPaths);
            }
            return noOfPaths;
        }
    }


}
