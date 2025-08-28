#include <bits/stdc++.h>
using namespace std;

int precedence(char op) {
    if(op == '+'||op == '-') return 1;
    if(op == '*'||op == '/') return 2;
    return 0;
}

string infixToPostfix(string expr) {
    stack<char> st;
    string output;
    for (char c : expr) {
        if (isspace(c)) continue;
        if (isalnum(c)) output += c;
        else if (c == '(') st.push(c);
        else if (c == ')') {
            while(!st.empty() && st.top() != '(') {
                output += st.top(); st.pop();
            }
            st.pop();
        } else {
            while(!st.empty() && precedence(c) <= precedence(st.top())) {
                output += st.top(); st.pop();
            }
            st.push(c);
        }
    }
    while(!st.empty()) { output += st.top(); st.pop(); }
    return output;
}

int main() {
    string expr = "(3+4)*2/(1-5)";
    cout << infixToPostfix(expr) << endl; // Output: 34+2*15-/
}
