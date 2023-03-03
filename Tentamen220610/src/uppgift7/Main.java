package uppgift7;

public class Main {

    public static void main(String[] args) {
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {5,4,3,2,1}));//4
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {4,4,3,2,2}));//3
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {1,2,4,3,5}));//5
        System.out.println(leastMancalaMoves(new int[] {1,2,3,4,5}, new int[] {1,2,4,4,5}));//olösbar
    }

    private static int leastMancalaMoves(int[] start, int[] end) {
        return 1;
    }

}
