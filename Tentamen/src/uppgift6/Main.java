package uppgift6;

import java.util.*;

public class Main {

    private static HashMap<Integer, Integer> hashMap;
    static int c = 0;

    public static void main(String[] args){
        System.out.println("Result: "+ packer2(10, new int[] {2,4,1}));
        System.out.println("Result: "+ packer2(20, new int[] {2,15,7,6,1}));
    }


    private static int packer2(int boxSize, int[] merchandise) {
        hashMap = new HashMap<>();
        int[] wares = new int[merchandise.length];
        packer2(boxSize, merchandise, wares);
        System.out.println(c);
        for (int i = 0; i < hashMap.size(); i++) {
            if (hashMap.containsValue(i)) return i;
        }
        return -1;
    }

    private static int sumArr(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }


    private static void packer2(int boxSize, int[] merchandise, int[] wares) {
        c++;
        if (hashMap.containsKey(Arrays.hashCode(wares))) return;
        if (boxSize == 0) {
            hashMap.put(Arrays.hashCode(wares), sumArr(wares));
        }
        if (!hashMap.containsKey(Arrays.hashCode(wares))){
            for (int i = 0; i < merchandise.length; i++) {
                if (boxSize - merchandise[i] >= 0) {
                    wares[i]++;
                    packer2(boxSize - merchandise[i], merchandise, wares);
                    wares[i]--;
                }
            }
        }
    }



    private static int packer(int boxSize, int[] merchandise) {
        Arrays.sort(merchandise);
        int i = merchandise.length - 1;
        int wares = 0;
        while (boxSize >= 0 && i >= 0) {
            if (boxSize - merchandise[i] >= 0) {
                boxSize -= merchandise[i];
                wares++;
            }
            else
                i--;
        }
        return wares;
    }



}
