package NB15;

public class NumberConverter {


    public static int binaryToDecimal(String bin) {
        int result = 0;
        int dec = binaryToDec(bin, result);
        return dec;
    }

    private static int binaryToDec(String bin, int result) {
        if (bin.equals("")) {
            return result;
        }
        int mult = bin.length() - 1;
        if (bin.charAt(0) == '1') {
            return result + binaryToDec(bin.substring(1), (int) Math.pow(2, mult));
        } else {
            return result + binaryToDec(bin.substring(1), 0);
        }
    }

    public static String decimalToBinary(int decimal) {
        String bin = "";
        return decimalToBinary(decimal, bin);
    }

    private static String decimalToBinary(int decimal, String bin) {
        if (decimal == 0) {
            return bin;
        }
        bin = decimal % 2 + bin;
        return decimalToBinary(decimal / 2, bin);
    }


}
