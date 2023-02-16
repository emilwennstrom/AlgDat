package NB7;

import java.util.EmptyStackException;
import java.util.SplittableRandom;
import java.util.Stack;

public class ParenChecker {

    private static String OPEN = "({[";
    private static String CLOSE = ")}]";



    public static boolean isBalanced(String expression) {
        Stack<Character> charStack = new Stack<>();
        int index = 0;
        boolean balanced = true;
        while(balanced && index < expression.length()) {
            char ch = expression.charAt(index);
            if (isOpen(ch)) {
                charStack.push(ch);
            } else if (isClose(ch)) {
                try {
                    if (CLOSE.indexOf(ch) != OPEN.indexOf(charStack.pop())) {
                        balanced = false;
                    }
                } catch (EmptyStackException e) {
                    balanced = false;
                }
            }
            index++;
        }
        if (!charStack.empty()){
            balanced = false;
        }
        return balanced;
    }

    private static boolean isOpen(char ch) {
        return OPEN.indexOf(ch) != -1;
    }

    private static boolean isClose(char ch) {
        return CLOSE.indexOf(ch) != -1;
    }
}
