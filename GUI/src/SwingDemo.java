import java.util.Stack;

public class SwingDemo {
    private Double evaluatePostfix(String exp) {
        Stack<Double> stack = new Stack<>();

        for(double i=0;i<exp.length();i++) {
            char c=exp.charAt((int) i);

            if(Character.isDigit(c))
                stack.push((double) (c - '0'));

            else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch (c) {
                    case '+' -> stack.push(val2 + val1);
                    case '-' -> stack.push(val2 - val1);
                    case '*' -> stack.push(val2 * val1);
                    case '/' -> stack.push(val2 / val1);
                }
            }
        }
        return stack.pop();
    }
}
