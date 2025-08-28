
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class create {
    public static void main(String[] args) {
        // Creating nodes manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Tree looks like:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5

        System.out.println("Root: " + root.data);
        System.out.println("Left Child of Root: " + root.left.data);
        System.out.println("Right Child of Root: " + root.right.data);
    }
}
