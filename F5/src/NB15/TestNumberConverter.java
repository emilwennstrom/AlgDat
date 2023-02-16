package NB15;

public class TestNumberConverter {
    public static void main(String[] args) {

        int num = 233;

        String bin = NumberConverter.decimalToBinary(num);
        int dec = NumberConverter.binaryToDecimal(bin);

        System.out.println("num in bin: " + bin);
        System.out.println("num in dec: "+ dec);

        dec = NumberConverter.binaryToDecimal("10110010");

        System.out.println("10110010 in dec: "+ dec);


    }
}
