#include <bits/stdc++.h>
using namespace std;

int evaluatePrefix(string expr) {
    stack<int> st;
    for (int i = expr.length() - 1; i >= 0; i--) {
        char c = expr[i];
        if (c == ' ') continue;
        if (isdigit(c)) {
            st.push(c - '0');
        } else {
            int a = st.top(); st.pop();
            int b = st.top(); st.pop();
            switch(c) {
                case '+': st.push(a + b); break;
                case '-': st.push(a - b); break;
                case '*': st.push(a * b); break;
                case '/': st.push(a / b); break;
            }
        }
    }
    return st.top();
}

int main() {
    string expr = "* + 3 4 2"; // (3+4)*2
    cout << evaluatePrefix(expr) << endl; // Output: 14
}
