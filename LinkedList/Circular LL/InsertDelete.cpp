#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int value) {
        data = value;
        next = nullptr;
    }
};

class CircularLinkedList {
private:
    Node* head;

public:
    CircularLinkedList() {
        head = nullptr;
    }

    // Insert at beginning
    void insertAtBeginning(int value) {
        Node* newNode = new Node(value);
        if (!head) {
            head = newNode;
            newNode->next = head;
            return;
        }
        Node* temp = head;
        while (temp->next != head) temp = temp->next;
        newNode->next = head;
        temp->next = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node* newNode = new Node(value);
        if (!head) {
            head = newNode;
            newNode->next = head;
            return;
        }
        Node* temp = head;
        while (temp->next != head) temp = temp->next;
        temp->next = newNode;
        newNode->next = head;
    }

    // Delete by value
    void deleteNode(int value) {
        if (!head) return;

        Node* temp = head;
        Node* prev = nullptr;

        // Deleting head node
        if (head->data == value) {
            if (head->next == head) { // only one node
                delete head;
                head = nullptr;
                return;
            }
            while (temp->next != head) temp = temp->next; // last node
            Node* toDelete = head;
            temp->next = head->next;
            head = head->next;
            delete toDelete;
            return;
        }

        prev = head;
        temp = head->next;
        while (temp != head && temp->data != value) {
            prev = temp;
            temp = temp->next;
        }

        if (temp == head) {
            cout << "Value not found.\n";
            return;
        }

        prev->next = temp->next;
        delete temp;
    }

    // Length of CLL
    int length() {
        if (!head) return 0;
        int count = 1;
        Node* temp = head->next;
        while (temp != head) {
            count++;
            temp = temp->next;
        }
        return count;
    }

    // Display
    void display() {
        if (!head) {
            cout << "List is empty.\n";
            return;
        }
        Node* temp = head;
        do {
            cout << temp->data << " -> ";
            temp = temp->next;
        } while (temp != head);
        cout << "(back to head)\n";
    }
};

int main() {
    CircularLinkedList cll;

    cll.insertAtEnd(10);
    cll.insertAtEnd(20);
    cll.insertAtEnd(30);
    cll.insertAtBeginning(5);

    cout << "CLL: ";
    cll.display();
    cout << "Length: " << cll.length() << endl;

    cll.deleteNode(20);
    cout << "After deleting 20: ";
    cll.display();
    cout << "Length: " << cll.length() << endl;

    return 0;
}
