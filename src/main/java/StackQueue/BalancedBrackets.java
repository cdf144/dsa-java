package StackQueue;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((top == '(' && c == ')')
                        || (top == '[' && c == ']')
                        || (top == '{' && c == '}')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
