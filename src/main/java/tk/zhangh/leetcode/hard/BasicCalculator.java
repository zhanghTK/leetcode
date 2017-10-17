package tk.zhangh.leetcode.hard;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/5/8.
 */
public class BasicCalculator {
    public int calculate(String s) {
        // 去掉所有空格
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        // 先压入一个1进栈，可以理解为有个大括号在最外面
        stack.push(1);
        int i = 0, res = 0, sign = 1;
        while (i < s.length()) {
            char c = s.charAt(i);
            // 遇到正号，将当前的符号变为正号
            if (c == '+') {
                sign = 1;
                i++;
                // 遇到负号，将当前的符号变为负号
            } else if (c == '-') {
                sign = -1;
                i++;
                // 遇到左括号，计算当前所属的符号，压入栈中
                // 计算方法是当前符号乘以当前所属括号的符号
            } else if (c == '(') {
                stack.push(sign * stack.peek());
                sign = 1;
                i++;
                // 遇到右括号，当前括号结束，出栈
            } else if (c == ')') {
                stack.pop();
                i++;
                // 遇到数字，计算其正负号并加入总结果中
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += num * sign * stack.peek();
            }
        }
        return res;
    }
}
