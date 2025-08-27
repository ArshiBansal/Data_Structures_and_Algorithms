class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class create {
    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Linking nodes circularly
        head.next = second;
        second.next = third;
        third.next = head; // last node points back to head

        // Traversing circular linked list (print 2 cycles to show circularity)
        Node temp = head;
        int count = 0; // to avoid infinite loop
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            count++;
        } while (temp != head && count < 10); // prevent infinite loop
        System.out.println("(back to head)");
    }
}
