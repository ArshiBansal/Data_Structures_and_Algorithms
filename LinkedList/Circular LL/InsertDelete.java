class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class InsertDelete {
    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    // Delete by value
    void deleteNode(int value) {
        if (head == null) return;

        Node temp = head;
        Node prev = null;

        // Deleting head
        if (head.data == value) {
            if (head.next == head) { // only one node
                head = null;
                return;
            }
            while (temp.next != head) temp = temp.next; // last node
            temp.next = head.next;
            head = head.next;
            return;
        }

        prev = head;
        temp = head.next;
        while (temp != head && temp.data != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == head) {
            System.out.println("Value not found.");
            return;
        }

        prev.next = temp.next;
    }

    // Length of CLL
    int length() {
        if (head == null) return 0;
        int count = 1;
        Node temp = head.next;
        while (temp != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        InsertDelete cll = new InsertDelete();

        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtBeginning(5);

        System.out.print("CLL: ");
        cll.display();
        System.out.println("Length: " + cll.length());

        cll.deleteNode(20);
        System.out.print("After deleting 20: ");
        cll.display();
        System.out.println("Length: " + cll.length());
    }
}
