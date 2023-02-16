package NB11;

public class BiggestInt {


    public static int getBiggestInt(int[] arr) {
        int start = 0;
        int biggest = arr[start];
        return getBiggestInt(arr, biggest, start + 1);


    }
    private static int getBiggestInt(int[] arr, int biggest, int start) {
        if (arr.length == 1) return arr[0];
        if (biggest < arr[start]) biggest = arr[start];
        return getBiggestInt(arr, biggest, start + 1);
    }
}
