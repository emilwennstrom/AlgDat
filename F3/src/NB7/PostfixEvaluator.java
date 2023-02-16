package NB7;

import java.util.Stack;
import java.util.EmptyStackException;


public class PostfixEvaluator {

    static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    public PostfixEvaluator() {
        operandStack = new Stack<>();
    }



    public int eval(String expression) throws SyntaxErrorException {
        String[] tokens = expression.split(" +");
        try {
            for (String next : tokens) {
                if (Character.isDigit(next.charAt(0))) {
                    operandStack.push(Integer.parseInt(next));
                } else if (isOperator(next.charAt(0))) {
                    operandStack.push(evalOp(next.charAt(0)));
                } else {
                    throw new SyntaxErrorException("Syntax error: Invalid character");
                }
            }

        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error: Stack is empty");
        }
        int result =  operandStack.pop();
        if (!operandStack.empty()) {
            throw new SyntaxErrorException(": Stack is not empty");
        }
        return result;
    }

    private int evalOp(char op) {
        int b = operandStack.pop();
        int a = operandStack.pop();
        switch (op) {
            case '+' -> a = a + b;
            case '-' -> a = a - b;
            case '*' -> a = a * b;
            case '/' -> a = a / b;
            default -> {
            }
        }
        return a;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }


}
