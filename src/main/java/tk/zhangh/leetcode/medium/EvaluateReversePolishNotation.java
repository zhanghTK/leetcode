package tk.zhangh.leetcode.medium;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/4/25.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        String operators = "+-*/";
        for (String token : tokens) {
            if (!operators.contains(token)) {
                s.push(Integer.valueOf(token));
                continue;
            }
            int a = s.pop();
            int b = s.pop();
            if (token.equals("+")) {
                s.push(b + a);
            } else if (token.equals("-")) {
                s.push(b - a);
            } else if (token.equals("*")) {
                s.push(b * a);
            } else {
                s.push(b / a);
            }
        }
        return s.pop();
    }
}
