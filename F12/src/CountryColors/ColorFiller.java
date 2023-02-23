package CountryColors;

import java.util.Arrays;

public class ColorFiller {

    private static boolean[][] borders;


    public static int[] fillCountrys(int size){
        int[] country = new int[size];
        boolean[] color = new boolean[size];

        for (int i = 0; i < size; i++){
            color[i] = false;
            for (int j = 0; j < size; j++) {
                if (borders[i][j] && country[j] != 0) {
                    color[country[j]] = true;
                }
            }
            for (int j = 1; j < color.length; j++) {
                if (!color[j]) {
                    country[i] = j;
                    break;
                }
            }

        }

        return country;



    }

    public static void setBorder(int row, int col) {
        borders[row][col] = true;
        borders[col][row] = true;
    }




    public static void main(String[] args) {
        int size = 5;
        borders = new boolean[size][size];
        setBorder(2, 0);
        setBorder(1,0);
        setBorder(3, 4);
        setBorder(4,1);
        setBorder(3,2);
        int[] c = fillCountrys(size);

        System.out.println(Arrays.toString(c));


    }
}
