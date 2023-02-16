public class Main {
    public static void main(String[] args) {
        String hello = "Hello";


        //System.out.println(reverseString("kayak"));

        //System.out.println(isPalindrome("k"));

        //System.out.println(binToDec("11111111"));

        System.out.println(count7(717));




    }

    public static String reverseString(String input) {
        if (input.equals("")) {
            return "";
        }
        return reverseString(input.substring(1))  + input.charAt(0);
    }

    public static boolean isPalindrome(String input) {
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }

    public static int sumOfN(int n) {
        int start = 1;
        return sumOfN(n, start);
    }

    private static int sumOfN(int n, int start) {
        if (start == n) return n;
        return start + sumOfN(n, start + 1);
    }


    public static int count7(int n) {
        int count = 0;
        return count7(count, n);

    }

    public static int count7(int count, int n) {
        if (n == 0) return count;
        if (n % 10 == 7){
            return count7(count + 1, n/10);
        }

        return count7(count, n / 10);
    }


}

