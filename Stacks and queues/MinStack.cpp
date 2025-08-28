#include <iostream>
#include <stack>
#include <string>
using namespace std;

class MinStack {
    stack<int> st;
    stack<int> minSt;

public:
    void push(int val) {
        st.push(val);
        if (minSt.empty() || val <= minSt.top()) {
            minSt.push(val);
        }
        cout << val << " pushed\n";
    }

    void pop() {
        if (st.empty()) {
            cout << "Stack is empty!\n";
            return;
        }
        if (st.top() == minSt.top()) {
            minSt.pop();
        }
        cout << st.top() << " popped\n";
        st.pop();
    }

    void top() {
        if (st.empty()) {
            cout << "Stack is empty!\n";
            return;
        }
        cout << "Top: " << st.top() << "\n";
    }

    void getMin() {
        if (minSt.empty()) {
            cout << "Stack is empty!\n";
            return;
        }
        cout << "Min: " << minSt.top() << "\n";
    }
};

int main() {
    MinStack minStack;
    string command;

    cout << "Enter commands: push X / pop / top / getMin / exit\n";

    while (true) {
        cout << "> ";
        getline(cin, command);

        if (command == "exit") break;

        if (command.substr(0, 4) == "push") {
            int val = stoi(command.substr(5));
            minStack.push(val);
        } else if (command == "pop") {
            minStack.pop();
        } else if (command == "top") {
            minStack.top();
        } else if (command == "getMin") {
            minStack.getMin();
        } else {
            cout << "Invalid command!\n";
        }
    }

    cout << "Program terminated.\n";
    return 0;
}
