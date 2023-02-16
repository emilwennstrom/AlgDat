package NB7;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
import NB7.PostfixEvaluator.SyntaxErrorException;

public class InfixToPostfix {

    private Stack<Character> operatorStack;
    private StringBuilder postfix;

    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    private static final String OPERATORS = "+-*/()";

    public String convert(String infix) throws SyntaxErrorException {
        postfix = new StringBuilder();
        operatorStack = new Stack<Character>();
        try {
            String nextToken;
            Scanner scan = new Scanner(infix);
            while ((nextToken = scan.findInLine(
                    "[\\p{L}\\p{N}]+|[-+/*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar)
                        || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                }
                else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                }
                else {
                    throw new SyntaxErrorException("Unexpected char: " + firstChar);
                }
            }
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                if (op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                }
                postfix.append(op);
                postfix.append(' ');
            }
            return postfix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax error: The stack is empty");
        }
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
                   operatorStack.pop();
                   if (top == '(') {
                       break;
                   }
                   postfix.append(top);
                   postfix.append(' ');
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
