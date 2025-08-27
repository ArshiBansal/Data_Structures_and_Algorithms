// using array

public class createqueue {
    private int front, rear, size;
    private int[] arr;

    public createqueue(int capacity) {
        size = capacity;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = data;
        System.out.println(data + " enqueued");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = arr[front];
        if (front == rear) {
            front = rear = -1; // empty
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        createqueue q = new createqueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30
        System.out.println("Front: " + q.peek());
        q.dequeue();
        q.display(); // Queue: 20 30
    }
}

//using linkedlist

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/* public class createqueue {
    private Node front, rear;

    public createqueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        createqueue q = new createqueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30
        System.out.println("Front: " + q.peek());
        q.dequeue();
        q.display(); // Queue: 20 30
    }
}
*/