package tk.zhangh.leetcode._1_50;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * Created by ZhangHao on 2017/9/11.
 */
public class _32_Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int last = -1;  // 最后一次匹配位置 - 1
        int max = 0;
        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftStack.push(i);
            } else if (s.charAt(i) == ')') {
                if (leftStack.isEmpty()) {
                    // 没有左括号匹配，更新最后一次匹配的位置
                    last = i;
                } else {
                    leftStack.pop();  // 进行匹配
                    if (leftStack.empty()) {
                        // 栈为空，根据最后一次匹配位置计算最长长度
                        max = Math.max(max, i - last);
                    } else {
                        // 栈不为空（只有出现连续左括号的情况才会发生栈不为空，可以根据前一个左括号匹配当前左括号）
                        // 栈顶元素即为最后一次匹配位置
                        max = Math.max(max, i - leftStack.peek());
                    }
                }
            }
        }
        return max;
    }
}
