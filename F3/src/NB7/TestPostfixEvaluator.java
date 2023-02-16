package NB7;

import NB7.PostfixEvaluator;

import java.util.Scanner;

public class TestPostfixEvaluator {
    public static void main(String[] args) {
        postfixFunc();

    }

    public static void postfixFunc() {
        PostfixEvaluator evaluator = new PostfixEvaluator();

        Scanner in = new Scanner(System.in);

        while(true) {
            String line = in.nextLine();
            if (!line.equals("")) {
                try {
                    int result = evaluator.eval(line);
                    System.out.println(result);
                } catch (PostfixEvaluator.SyntaxErrorException ex) {
                    System.out.println("Syntax error" + ex.getMessage());
                }
            } else {
                break;
            }
        }
    }
}