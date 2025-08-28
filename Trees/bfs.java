import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class bfs {
    static void bfsTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
        }
    }

    public static void main(String[] args) {
        // Create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.print("BFS Traversal (Level Order): ");
        bfsTraversal(root);
    }
}
