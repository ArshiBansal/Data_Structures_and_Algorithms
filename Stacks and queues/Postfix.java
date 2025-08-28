import java.util.*;

public class Postfix {
    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split(" ");
        
        for (String token : tokens) {
            if (token.matches("\\d+")) { // operand
                stack.push(Integer.parseInt(token));
            } else { // operator
                int b = stack.pop();
                int a = stack.pop();
                switch(token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "3 4 + 2 * 7 /"; // ((3+4)*2)/7
        System.out.println(evaluatePostfix(expr)); // Output: 2
    }
}
