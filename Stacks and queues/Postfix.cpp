#include <bits/stdc++.h>
using namespace std;

int evaluatePostfix(string expr) {
    stack<int> st;
    for (int i = 0; i < expr.length(); i++) {
        char c = expr[i];
        if (c == ' ') continue;
        if (isdigit(c)) {
            st.push(c - '0');
        } else {
            int b = st.top(); st.pop();
            int a = st.top(); st.pop();
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
    string expr = "3 4 + 2 * 7 /"; // ((3+4)*2)/7
    cout << evaluatePostfix(expr) << endl; // Output: 2
}
