// using array
#include <iostream>
using namespace std;

class QueueArray {
private:
    int front, rear, size;
    int* arr;

public:
    QueueArray(int capacity) {
        size = capacity;
        arr = new int[size];
        front = rear = -1;
    }

    ~QueueArray() {
        delete[] arr;
    }

    bool isEmpty() {
        return front == -1;
    }

    bool isFull() {
        return (rear + 1) % size == front;
    }

    void enqueue(int data) {
        if (isFull()) {
            cout << "Queue Overflow" << endl;
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        arr[rear] = data;
        cout << data << " enqueued" << endl;
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow" << endl;
            return -1;
        }
        int val = arr[front];
        if (front == rear) {
            front = rear = -1; // queue becomes empty
        } else {
            front = (front + 1) % size;
        }
        return val;
    }

    int peek() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return -1;
        }
        return arr[front];
    }

    void display() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return;
        }
        cout << "Queue: ";
        int i = front;
        while (true) {
            cout << arr[i] << " ";
            if (i == rear) break;
            i = (i + 1) % size;
        }
        cout << endl;
    }
};

int main() {
    QueueArray q(5);
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.display(); // Queue: 10 20 30
    cout << "Front: " << q.peek() << endl;
    q.dequeue();
    q.display(); // Queue: 20 30
    return 0;
}

//using linkedlist

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

class QueueLL {
private:
    Node* front;
    Node* rear;

public:
    QueueLL() {
        front = rear = nullptr;
    }

    bool isEmpty() {
        return front == nullptr;
    }

    void enqueue(int data) {
        Node* newNode = new Node();
        newNode->data = data;
        newNode->next = nullptr;

        if (rear == nullptr) {
            front = rear = newNode;
        } else {
            rear->next = newNode;
            rear = newNode;
        }
        cout << data << " enqueued" << endl;
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow" << endl;
            return -1;
        }
        int val = front->data;
        Node* temp = front;
        front = front->next;
        if (front == nullptr) rear = nullptr;
        delete temp;
        return val;
    }

    int peek() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return -1;
        }
        return front->data;
    }

    void display() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return;
        }
        cout << "Queue: ";
        Node* temp = front;
        while (temp != nullptr) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }
};

int main() {
    QueueLL q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.display(); // Queue: 10 20 30
    cout << "Front: " << q.peek() << endl;
    q.dequeue();
    q.display(); // Queue: 20 30
    return 0;
}
