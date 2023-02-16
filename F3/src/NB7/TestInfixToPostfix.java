package NB7;

import javax.swing.*;

public class TestInfixToPostfix {
    public static void main(String[] args) {
        InfixToPostfix inToPost = new InfixToPostfix();
        String infix = JOptionPane.showInputDialog("Enter an infix expression");
        try {
            if (ParenChecker.isBalanced(infix)) {
                String postfix = inToPost.convert(infix);
                JOptionPane.showMessageDialog(null, "Infix expression " +
                        infix + "\n converts to " + postfix);
                PostfixEvaluator eval = new PostfixEvaluator();
                int result = eval.eval(postfix);
                JOptionPane.showMessageDialog(null, "Result = " + result);
            } else {
                JOptionPane.showMessageDialog(null, "The expression is not balanced");
            }
        } catch (PostfixEvaluator.SyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (StringIndexOutOfBoundsException e2 ){
            JOptionPane.showMessageDialog(null, "Enter a String");
        }
    }
}
