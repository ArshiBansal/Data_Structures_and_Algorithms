#include <iostream>
#include <algorithm>
using namespace std;

struct Node {
    int key;
    Node* left;
    Node* right;
    Node(int k) {
        key = k;
        left = right = nullptr;
    }
};

// Insert
Node* insert(Node* root, int key) {
    if (!root) return new Node(key);
    if (key < root->key) root->left = insert(root->left, key);
    else if (key > root->key) root->right = insert(root->right, key);
    return root;
}

// Search
Node* search(Node* root, int key) {
    if (!root || root->key == key) return root;
    return key < root->key ? search(root->left, key) : search(root->right, key);
}

// Min Node
Node* minValueNode(Node* node) {
    Node* current = node;
    while (current && current->left) current = current->left;
    return current;
}

// Max Node
Node* maxValueNode(Node* node) {
    Node* current = node;
    while (current && current->right) current = current->right;
    return current;
}

// Height
int height(Node* root) {
    if (!root) return 0;
    return 1 + max(height(root->left), height(root->right));
}

// Deletion
Node* deleteNode(Node* root, int key) {
    if (!root) return root;
    if (key < root->key) root->left = deleteNode(root->left, key);
    else if (key > root->key) root->right = deleteNode(root->right, key);
    else {
        if (!root->left) { Node* temp = root->right; delete root; return temp; }
        else if (!root->right) { Node* temp = root->left; delete root; return temp; }
        Node* temp = minValueNode(root->right);
        root->key = temp->key;
        root->right = deleteNode(root->right, temp->key);
    }
    return root;
}

// Inorder Traversal
void inorder(Node* root) {
    if (root) {
        inorder(root->left);
        cout << root->key << " ";
        inorder(root->right);
    }
}

int main() {
    Node* root = nullptr;
    int n, key;
    cout << "Enter number of nodes to insert: ";
    cin >> n;
    for (int i = 0; i < n; i++) {
        cout << "Enter key " << i+1 << ": ";
        cin >> key;
        root = insert(root, key);
    }

    cout << "Inorder Traversal: ";
    inorder(root);
    cout << endl;

    cout << "Height of BST: " << height(root) << endl;
    cout << "Min node: " << minValueNode(root)->key << endl;
    cout << "Max node: " << maxValueNode(root)->key << endl;

    cout << "Enter key to search: ";
    cin >> key;
    cout << (search(root, key) ? "Found" : "Not Found") << endl;

    cout << "Enter key to delete: ";
    cin >> key;
    root = deleteNode(root, key);
    cout << "Inorder after deletion: ";
    inorder(root);
    cout << endl;

    return 0;
}
