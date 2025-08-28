#include <bits/stdc++.h>
using namespace std;

string reverseParentheses(string expr) {
    for (char &c : expr) {
        if(c == '(') c = ')';
        else if(c == ')') c = '(';
    }
    reverse(expr.begin(), expr.end());
    return expr;
}

string infixToPrefix(string expr) {
    expr = reverseParentheses(expr);
    string postfix = infixToPostfix(expr);
    reverse(postfix.begin(), postfix.end());
    return postfix;
}

int main() {
    string expr = "(3+4)*2/(1-5)";
    cout << infixToPrefix(expr) << endl; // Output: /*+34 2-15
}
