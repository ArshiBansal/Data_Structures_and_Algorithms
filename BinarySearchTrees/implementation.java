import java.util.Scanner;

class Node {
    int key;
    Node left, right;
    Node(int key) { this.key = key; left = right = null; }
}

class BST {
    Node root;

    // Insert
    Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insert(root.left, key);
        else if (key > root.key) root.right = insert(root.right, key);
        return root;
    }

    // Search
    Node search(Node root, int key) {
        if (root == null || root.key == key) return root;
        return key < root.key ? search(root.left, key) : search(root.right, key);
    }

    // Min Node
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Max Node
    Node maxValueNode(Node node) {
        Node current = node;
        while (current.right != null) current = current.right;
        return current;
    }

    // Height
    int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Delete
    Node deleteNode(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = deleteNode(root.left, key);
        else if (key > root.key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
        return root;
    }

    // Inorder
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }
}

public class implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        System.out.print("Enter number of nodes to insert: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter key " + (i+1) + ": ");
            int key = sc.nextInt();
            tree.root = tree.insert(tree.root, key);
        }

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Height of BST: " + tree.height(tree.root));
        System.out.println("Min node: " + tree.minValueNode(tree.root).key);
        System.out.println("Max node: " + tree.maxValueNode(tree.root).key);

        System.out.print("Enter key to search: ");
        int key = sc.nextInt();
        System.out.println(tree.search(tree.root, key) != null ? "Found" : "Not Found");

        System.out.print("Enter key to delete: ");
        key = sc.nextInt();
        tree.root = tree.deleteNode(tree.root, key);
        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);
        System.out.println();
        sc.close();
    }
}
