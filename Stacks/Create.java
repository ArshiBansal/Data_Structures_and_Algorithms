// using LinkedList

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using linked list
public class Create {
    private Node top;

    // Constructor
    public Create() {
        top = null;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Push operation
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Display stack
    public void display() {
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method to test
    public static void main(String[] args) {
        Create stack = new Create(); // Use correct class name
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();        // Stack: 30 -> 20 -> 10 -> NULL
        System.out.println("Top: " + stack.peek()); // Top: 30
        stack.pop();
        stack.display();        // Stack: 20 -> 10 -> NULL
    }
}

// using arrays
/*
public class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // stack is empty initially
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Push operation
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = data; // increment top and insert
        System.out.println(data + " pushed to stack");
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stackArray[top--]; // return top element and decrement top
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    // Display stack
    public void display() {
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " -> ");
        }
        System.out.println("NULL");
    }

    // Main method to test
    public static void main(String[] args) {
        StackArray stack = new StackArray(5); // stack of size 5
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();          // Stack: 30 -> 20 -> 10 -> NULL
        System.out.println("Top: " + stack.peek()); // Top: 30
        stack.pop();
        stack.display();          // Stack: 20 -> 10 -> NULL
    }
}
 */