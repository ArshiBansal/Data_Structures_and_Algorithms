// using LinkedList
#include <iostream>
using namespace std;

// Node structure
struct Node {
    int data;
    Node* next;
};

// Stack class
class Stack {
    Node* top;

public:
    Stack() { top = nullptr; }

    // Check if stack is empty
    bool isEmpty() {
        return top == nullptr;
    }

    // Push operation
    void push(int data) {
        Node* newNode = new Node();
        newNode->data = data;
        newNode->next = top;
        top = newNode;
        cout << data << " pushed to stack\n";
    }

    // Pop operation
    int pop() {
        if (isEmpty()) {
            cout << "Stack Underflow\n";
            return -1;
        }
        int popped = top->data;
        Node* temp = top;
        top = top->next;
        delete temp;
        return popped;
    }

    // Peek operation
    int peek() {
        if (isEmpty()) {
            cout << "Stack is empty\n";
            return -1;
        }
        return top->data;
    }

    // Display stack
    void display() {
        Node* temp = top;
        cout << "Stack: ";
        while (temp != nullptr) {
            cout << temp->data << " -> ";
            temp = temp->next;
        }
        cout << "NULL\n";
    }
};

// Main function to test
int main() {
    Stack stack;
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.display();           // Stack: 30 -> 20 -> 10 -> NULL
    cout << "Top: " << stack.peek() << endl; // Top: 30
    stack.pop();
    stack.display();           // Stack: 20 -> 10 -> NULL
    return 0;
}

//using arrays
/*
#include <iostream>
using namespace std;

class StackArray {
private:
    int* stackArray;
    int top;
    int maxSize;

public:
    // Constructor
    StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // stack is empty initially
    }

    // Destructor
    ~StackArray() {
        delete[] stackArray;
    }

    // Check if stack is empty
    bool isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    bool isFull() {
        return top == maxSize - 1;
    }

    // Push operation
    void push(int data) {
        if (isFull()) {
            cout << "Stack Overflow" << endl;
            return;
        }
        stackArray[++top] = data;
        cout << data << " pushed to stack" << endl;
    }

    // Pop operation
    int pop() {
        if (isEmpty()) {
            cout << "Stack Underflow" << endl;
            return -1;
        }
        return stackArray[top--];
    }

    // Peek operation
    int peek() {
        if (isEmpty()) {
            cout << "Stack is empty" << endl;
            return -1;
        }
        return stackArray[top];
    }

    // Display stack
    void display() {
        cout << "Stack: ";
        for (int i = top; i >= 0; i--) {
            cout << stackArray[i] << " -> ";
        }
        cout << "NULL" << endl;
    }
};

// Main function to test
int main() {
    StackArray stack(5); // stack of size 5
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.display();           // Stack: 30 -> 20 -> 10 -> NULL
    cout << "Top: " << stack.peek() << endl; // Top: 30
    stack.pop();
    stack.display();           // Stack: 20 -> 10 -> NULL
    return 0;
}
*/