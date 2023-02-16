package NB7;

public class TestParenChecker {
    public static void main(String[] args) {

        String isTrue = "(w * [x + y] / z - [p / {r - q}])";
        String isFalse = "(w * [x + y) / z - [p / {r - q}])";

        String test = "({)}";



        System.out.println(ParenChecker.isBalanced(isTrue));
        System.out.println(ParenChecker.isBalanced(isFalse));

        System.out.println(ParenChecker.isBalanced(test));

    }
}
