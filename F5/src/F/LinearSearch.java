package F;

public class LinearSearch {



    public static void main(String[] args) {
        Integer[] ints = new Integer[10];

        for (int i = 0; i < 10; i++) {
            ints[i] = i + 1;
        }

        System.out.println(linearSearch(ints, 5));
    }

     public static int linearSearch(Object[] array, Object target) {
         return linearSearch(array, target, 0);
     }

     private static int linearSearch(Object[] array, Object target, int pos) {
         if (pos == array.length) {
             return -1;
         } else if (target.equals(array[pos])) {
             return pos;
         } else {
             return linearSearch(array, target, pos+1);
         }
     }


}
