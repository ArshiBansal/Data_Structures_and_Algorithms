class Node {
    int data;
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}

public class InsertDelete {
    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete by value
    void deleteNode(int value) {
        if (head == null) return;

        Node temp = head;

        if (head.data == value) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }

        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    // Length of DLL
    int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        InsertDelete dll = new InsertDelete();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);

        System.out.print("DLL: ");
        dll.display();

        System.out.println("Length of DLL: " + dll.length());

        dll.deleteNode(20);
        System.out.print("After deleting 20: ");
        dll.display();

        System.out.println("Length after deletion: " + dll.length());
    }
}
