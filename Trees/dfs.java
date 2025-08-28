class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class dfs {
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Build tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.print("\nPreorder Traversal: ");
        preorder(root);
        System.out.print("\nPostorder Traversal: ");
        postorder(root);
    }
}
