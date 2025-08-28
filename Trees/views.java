import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int val){ data = val; left = right = null; }
}

public class views {

    // ===== Top View =====
    static void topView(Node root) {
        if (root == null) return;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));

        while (!q.isEmpty()) {
            Pair<Node,Integer> p = q.poll();
            Node node = p.getKey();
            int hd = p.getValue();
            map.putIfAbsent(hd, node.data);

            if (node.left != null) q.add(new Pair<>(node.left, hd-1));
            if (node.right != null) q.add(new Pair<>(node.right, hd+1));
        }

        System.out.print("Top View: ");
        for (int val : map.values()) System.out.print(val + " ");
        System.out.println();
    }

    // ===== Bottom View =====
    static void bottomView(Node root) {
        if (root == null) return;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));

        while (!q.isEmpty()) {
            Pair<Node,Integer> p = q.poll();
            Node node = p.getKey();
            int hd = p.getValue();
            map.put(hd, node.data); // overwrite to get bottom-most

            if (node.left != null) q.add(new Pair<>(node.left, hd-1));
            if (node.right != null) q.add(new Pair<>(node.right, hd+1));
        }

        System.out.print("Bottom View: ");
        for (int val : map.values()) System.out.print(val + " ");
        System.out.println();
    }

    // ===== Right View =====
    static void rightView(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print("Right View: ");
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0;i<n;i++) {
                Node temp = q.poll();
                if (i==n-1) System.out.print(temp.data + " ");
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        System.out.println();
    }

    // ===== Left View =====
    static void leftView(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        System.out.print("Left View: ");
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i=0;i<n;i++) {
                Node temp = q.poll();
                if (i==0) System.out.print(temp.data + " ");
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
        bottomView(root);
        rightView(root);
        leftView(root);
    }
}

// Helper Pair class for Java 8
class Pair<K,V> {
    K key; V value;
    Pair(K k, V v){ key=k; value=v; }
    K getKey(){ return key; }
    V getValue(){ return value; }
}
