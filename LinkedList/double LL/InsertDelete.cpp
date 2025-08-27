#include <iostream>
using namespace std;

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

class DoublyLinkedList {
private:
    Node* head;

public:
    DoublyLinkedList() {
        head = NULL;
    }

    // Insert at beginning
    void insertAtBeginning(int value) {
        Node* newNode = new Node(value);
        newNode->next = head;
        if (head != NULL) head->prev = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int value) {
        Node* newNode = new Node(value);
        if (head == NULL) {
            head = newNode;
            return;
        }
        Node* temp = head;
        while (temp->next != NULL) temp = temp->next;
        temp->next = newNode;
        newNode->prev = temp;
    }

    // Delete by value
    void deleteNode(int value) {
        if (head == NULL) return;

        Node* temp = head;

        // Deleting head
        if (head->data == value) {
            head = head->next;
            if (head != NULL) head->prev = NULL;
            delete temp;
            return;
        }

        while (temp != NULL && temp->data != value) {
            temp = temp->next;
        }

        if (temp == NULL) {
            cout << "Value not found.\n";
            return;
        }

        if (temp->next != NULL) temp->next->prev = temp->prev;
        if (temp->prev != NULL) temp->prev->next = temp->next;

        delete temp;
    }

    // Length of DLL
    int length() {
        int count = 0;
        Node* temp = head;
        while (temp != NULL) {
            count++;
            temp = temp->next;
        }
        return count;
    }

    // Display
    void display() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " <-> ";
            temp = temp->next;
        }
        cout << "NULL\n";
    }
};

int main() {
    DoublyLinkedList dll;

    dll.insertAtEnd(10);
    dll.insertAtEnd(20);
    dll.insertAtEnd(30);
    dll.insertAtBeginning(5);

    cout << "DLL: ";
    dll.display();

    cout << "Length of DLL: " << dll.length() << endl;

    dll.deleteNode(20);
    cout << "After deleting 20: ";
    dll.display();

    cout << "Length after deletion: " << dll.length() << endl;

    return 0;
}
