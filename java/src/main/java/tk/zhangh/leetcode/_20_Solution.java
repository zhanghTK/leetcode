package tk.zhangh.leetcode;

import java.util.Stack;

/**
 * Valid Parentheses
 * Created by ZhangHao on 2017/9/6.
 */
public class _20_Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ("([{".contains(String.valueOf(c))) {
                // 左括号入栈
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isMatch(stack.peek(), c)) {
                    // 匹配，出栈
                    stack.pop();
                } else {
                    // 否则验证失败
                    return false;
                }
            }
        }
        // 栈空则验证通过
        return stack.isEmpty();
    }

    private boolean isMatch(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
    }
}
