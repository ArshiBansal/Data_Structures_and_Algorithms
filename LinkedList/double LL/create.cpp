#include <iostream>
using namespace std;

// Node structure
class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node(int value) {
        data = value;
        next = NULL;
        prev = NULL;
    }
};

int main() {
    // Creating nodes
    Node* head = new Node(10);
    Node* second = new Node(20);
    Node* third = new Node(30);

    // Linking nodes
    head->next = second;
    second->prev = head;
    second->next = third;
    third->prev = second;

    // Traversing forward
    Node* temp = head;
    cout << "Doubly Linked List forward: ";
    while (temp != NULL) {
        cout << temp->data << " <-> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;

    // Traversing backward
    temp = third;
    cout << "Doubly Linked List backward: ";
    while (temp != NULL) {
        cout << temp->data << " <-> ";
        temp = temp->prev;
    }
    cout << "NULL" << endl;

    return 0;
}
