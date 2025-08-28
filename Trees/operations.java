import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class operations {
    
    // Insert
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    // Search
    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }

    // BFS Traversal
    static void bfs(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
    }

    // Height
    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Count nodes
    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values: ");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }

        System.out.print("\nBFS Traversal: ");
        bfs(root);

        System.out.println("\nHeight of tree: " + height(root));
        System.out.println("Total nodes: " + countNodes(root));

        System.out.print("Enter value to search: ");
        int key = sc.nextInt();
        System.out.println(search(root, key) ? "Found" : "Not Found");

        sc.close();
    }
}
