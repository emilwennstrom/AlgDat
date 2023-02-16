package P7;

import NB7.PostfixEvaluator;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class CombEvalConvert {

    static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private Stack<Character> operatorStack;
    private Stack<Integer> operandStack;

    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    private static final String OPERATORS = "+-*/()";

    public String convert(String infix) throws SyntaxErrorException {
        operatorStack = new Stack<>();
        operandStack = new Stack<>();
        boolean nextIsOp = false;
        try {
            String nextToken;
            Scanner scan = new Scanner(infix);
            while ((nextToken = scan.findInLine(
                    "[\\p{L}\\p{N}]+|[-+/*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar)
                        || Character.isDigit(firstChar) && !nextIsOp) {
                    operandStack.push(Integer.parseInt(nextToken));
                    nextIsOp = true;

                }
                else if (isOperator(firstChar) && nextIsOp) {
                        nextIsOp = false;
                        processOperator(firstChar);
                    }
                else {
                    throw new SyntaxErrorException("Unexpected char: " + firstChar);
                }
            }
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                operandStack.push(evalOp(op));
                if (op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                }
            }
            int result = operandStack.peek();
            return String.valueOf(result);
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error: The stack is empty");
        }
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


    private void processOperator(char op) {
        if (operatorStack.empty() || op == '(') {
            operatorStack.push(op);
        } else {
            char top = operatorStack.peek();
            if (precedence(op) > precedence(top)) {
                operatorStack.push(op);
            }
            else {
                while (precedence(op) <= precedence(top) && !operatorStack.empty()) {
                    char a = operatorStack.pop();
                    operandStack.push(evalOp(a));
                    if (top == '(') {
                        break;
                    }
                    if (!operatorStack.empty()) {
                        top = operatorStack.peek();
                    }
                }
                if(op != ')') {
                    operatorStack.push(op);
                }
            }
        }

    }

    private int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }
}
