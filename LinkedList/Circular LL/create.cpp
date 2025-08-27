#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int value) {
        data = value;
        next = NULL;
    }
};

int main() {
    // Creating nodes
    Node* head = new Node(10);
    Node* second = new Node(20);
    Node* third = new Node(30);

    // Linking nodes circularly
    head->next = second;
    second->next = third;
    third->next = head;  // last node points back to head

    // Traversing circular linked list (print 2 cycles to show circularity)
    Node* temp = head;
    int count = 0;  // to avoid infinite loop
    cout << "Circular Linked List: ";
    do {
        cout << temp->data << " -> ";
        temp = temp->next;
        count++;
    } while (temp != head && count < 10); // just to prevent infinite loop
    cout << "(back to head)" << endl;

    return 0;
}
