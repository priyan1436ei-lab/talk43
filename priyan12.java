import java.util.Stack;

public class RPNCalculator {

    public static int evaluateRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If token is a number
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            }

            // If token is an operator
            else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;

                    case "-":
                        stack.push(a - b);
                        break;

                    case "*":
                        stack.push(a * b);
                        break;

                    case "/":
                        stack.push(a / b);
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Invalid operator: " + token
                        );
                }
            }
        }

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String[] expression = {
            "2", "1", "+", "3", "*"
        };

        int result = evaluateRPN(expression);

        System.out.println("RPN Expression Result: " + result);
    }
}
