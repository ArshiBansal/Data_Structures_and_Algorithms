import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();

        while (true) {
            System.out.println("Enter command: push X / pop / top / getMin / exit");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            if (input.startsWith("push")) {
                String[] parts = input.split(" ");
                int val = Integer.parseInt(parts[1]);
                minStack.push(val);
                System.out.println(val + " pushed");
            } else if (input.equalsIgnoreCase("pop")) {
                minStack.pop();
            } else if (input.equalsIgnoreCase("top")) {
                System.out.println("Top: " + minStack.top());
            } else if (input.equalsIgnoreCase("getMin")) {
                System.out.println("Min: " + minStack.getMin());
            } else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
        System.out.println("Program terminated.");
    }
}
