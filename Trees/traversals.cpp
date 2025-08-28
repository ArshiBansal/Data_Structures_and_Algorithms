// zigZagTraversal, boundaryTraversal, verticalOrder

#include <iostream>
#include <stack>
#include <queue>
#include <map>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val){ data = val; left = right = nullptr; }
};

// ===== Zig Zag Traversal =====
void zigZagTraversal(Node* root) {
    if (!root) return;
    stack<Node*> currentLevel, nextLevel;
    bool leftToRight = true;
    currentLevel.push(root);

    cout << "Zig Zag Traversal: ";
    while (!currentLevel.empty()) {
        Node* temp = currentLevel.top();
        currentLevel.pop();
        if (temp) {
            cout << temp->data << " ";
            if (leftToRight) {
                if (temp->left) nextLevel.push(temp->left);
                if (temp->right) nextLevel.push(temp->right);
            } else {
                if (temp->right) nextLevel.push(temp->right);
                if (temp->left) nextLevel.push(temp->left);
            }
        }
        if (currentLevel.empty()) {
            leftToRight = !leftToRight;
            swap(currentLevel, nextLevel);
        }
    }
    cout << endl;
}

// ===== Boundary Traversal =====
bool isLeaf(Node* node) { return !node->left && !node->right; }

void printLeaves(Node* root) {
    if (!root) return;
    printLeaves(root->left);
    if (isLeaf(root)) cout << root->data << " ";
    printLeaves(root->right);
}

void printBoundaryLeft(Node* root) {
    if (!root) return;
    if (root->left) {
        cout << root->data << " ";
        printBoundaryLeft(root->left);
    } else if (root->right) {
        cout << root->data << " ";
        printBoundaryLeft(root->right);
    }
}

void printBoundaryRight(Node* root) {
    if (!root) return;
    if (root->right) {
        printBoundaryRight(root->right);
        cout << root->data << " ";
    } else if (root->left) {
        printBoundaryRight(root->left);
        cout << root->data << " ";
    }
}

void boundaryTraversal(Node* root) {
    if (!root) return;
    cout << "Boundary Traversal: ";
    cout << root->data << " ";
    printBoundaryLeft(root->left);
    printLeaves(root->left);
    printLeaves(root->right);
    printBoundaryRight(root->right);
    cout << endl;
}

// ===== Vertical Order Traversal =====
void verticalOrder(Node* root) {
    if (!root) return;
    map<int, vector<int>> m;
    queue<pair<Node*, int>> q;
    q.push({root, 0});

    while (!q.empty()) {
        auto p = q.front(); q.pop();
        Node* node = p.first;
        int hd = p.second;
        m[hd].push_back(node->data);

        if (node->left) q.push({node->left, hd-1});
        if (node->right) q.push({node->right, hd+1});
    }

    cout << "Vertical Order Traversal: ";
    for (auto it : m) {
        for (int val : it.second) cout << val << " ";
    }
    cout << endl;
}

// ===== Main =====
int main() {
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->right = new Node(7);

    zigZagTraversal(root);
    boundaryTraversal(root);
    verticalOrder(root);
}
