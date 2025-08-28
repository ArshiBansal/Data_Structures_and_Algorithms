#include <iostream>
#include <queue>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};

// Insert in BST
Node* insert(Node* root, int val) {
    if (root == nullptr) return new Node(val);
    if (val < root->data)
        root->left = insert(root->left, val);
    else
        root->right = insert(root->right, val);
    return root;
}

// Search in BST
bool search(Node* root, int key) {
    if (root == nullptr) return false;
    if (root->data == key) return true;
    if (key < root->data) return search(root->left, key);
    return search(root->right, key);
}

// BFS Traversal
void bfs(Node* root) {
    if (!root) return;
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        Node* cur = q.front();
        q.pop();
        cout << cur->data << " ";
        if (cur->left) q.push(cur->left);
        if (cur->right) q.push(cur->right);
    }
}

// Height
int height(Node* root) {
    if (!root) return 0;
    return 1 + max(height(root->left), height(root->right));
}

// Count nodes
int countNodes(Node* root) {
    if (!root) return 0;
    return 1 + countNodes(root->left) + countNodes(root->right);
}

int main() {
    Node* root = nullptr;
    int n, val;
    cout << "Enter number of nodes: ";
    cin >> n;

    cout << "Enter values: ";
    for (int i = 0; i < n; i++) {
        cin >> val;
        root = insert(root, val);
    }

    cout << "\nBFS Traversal: ";
    bfs(root);

    cout << "\nHeight of tree: " << height(root);
    cout << "\nTotal nodes: " << countNodes(root);

    cout << "\nEnter value to search: ";
    cin >> val;
    cout << (search(root, val) ? "Found" : "Not Found") << endl;

    return 0;
}
