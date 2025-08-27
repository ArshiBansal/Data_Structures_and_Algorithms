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

public class Create {
    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Linking nodes
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        // Traversing forward
        Node temp = head;
        System.out.print("Doubly Linked List forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");

        // Traversing backward
        temp = third;
        System.out.print("Doubly Linked List backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}
