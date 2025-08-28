// top bottom left right views 

#include <iostream>
#include <queue>
#include <map>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val){ data = val; left = right = nullptr; }
};

// ===== Top View =====
void topView(Node* root) {
    if (!root) return;
    map<int,int> m; // hd -> node
    queue<pair<Node*, int>> q;
    q.push({root, 0});

    while (!q.empty()) {
        auto p = q.front(); q.pop();
        Node* node = p.first;
        int hd = p.second;

        if (m.find(hd) == m.end()) m[hd] = node->data;

        if (node->left) q.push({node->left, hd-1});
        if (node->right) q.push({node->right, hd+1});
    }

    cout << "Top View: ";
    for (auto it : m) cout << it.second << " ";
    cout << endl;
}

// ===== Bottom View =====
void bottomView(Node* root) {
    if (!root) return;
    map<int,int> m; // hd -> node
    queue<pair<Node*, int>> q;
    q.push({root, 0});

    while (!q.empty()) {
        auto p = q.front(); q.pop();
        Node* node = p.first;
        int hd = p.second;
        m[hd] = node->data; // overwrite to get bottom-most

        if (node->left) q.push({node->left, hd-1});
        if (node->right) q.push({node->right, hd+1});
    }

    cout << "Bottom View: ";
    for (auto it : m) cout << it.second << " ";
    cout << endl;
}

// ===== Right View =====
void rightView(Node* root) {
    if (!root) return;
    queue<Node*> q;
    q.push(root);
    cout << "Right View: ";
    while (!q.empty()) {
        int n = q.size();
        for (int i=0;i<n;i++) {
            Node* temp = q.front(); q.pop();
            if (i==n-1) cout << temp->data << " ";
            if (temp->left) q.push(temp->left);
            if (temp->right) q.push(temp->right);
        }
    }
    cout << endl;
}

// ===== Left View =====
void leftView(Node* root) {
    if (!root) return;
    queue<Node*> q;
    q.push(root);
    cout << "Left View: ";
    while (!q.empty()) {
        int n = q.size();
        for (int i=0;i<n;i++) {
            Node* temp = q.front(); q.pop();
            if (i==0) cout << temp->data << " ";
            if (temp->left) q.push(temp->left);
            if (temp->right) q.push(temp->right);
        }
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

    topView(root);
    bottomView(root);
    rightView(root);
    leftView(root);
}
