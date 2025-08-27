class Node {
    int data;
    Node next;
    Node prev;
    Node(int val) { data = val; next = prev = null; }
}

public class reverse {
    static Node reverse(Node head) {
        Node temp = null;
        Node curr = head;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            head = temp.prev;

        return head;
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        head.next = second; second.prev = head;
        second.next = third; third.prev = second;

        System.out.print("Original DLL: ");
        display(head);

        head = reverse(head);

        System.out.print("Reversed DLL: ");
        display(head);
    }
}
