class Node {
    int data;
    Node next;
    Node(int value) { data = value; next = null; }
}

public class reverse {
    static Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.print("Original SLL: ");
        display(head);

        head = reverse(head);

        System.out.print("Reversed SLL: ");
        display(head);
    }
}
