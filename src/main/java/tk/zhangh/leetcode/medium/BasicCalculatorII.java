package tk.zhangh.leetcode.medium;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/5/8.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Long> stk = new Stack<>();
        String firstNum = getNum(0, s);
        stk.push(Long.parseLong(firstNum));
        int i = firstNum.length();
        while (i < s.length()) {
            char c = s.charAt(i);
            // 拿出下一个数字
            String numStr = getNum(i + 1, s);
            if (c == '+') {
                stk.push(Long.parseLong(numStr));
            }
            if (c == '-') {
                stk.push(-Long.parseLong(numStr));
            }
            if (c == '*') {
                stk.push(stk.pop() * Long.parseLong(numStr));
            }
            if (c == '/') {
                stk.push(stk.pop() / Long.parseLong(numStr));
            }
            i = i + numStr.length() + 1;
        }
        long res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }
        return (int) res;
    }

    private String getNum(int i, String s) {
        StringBuilder num = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num.append(s.charAt(i));
            i++;
        }
        return num.toString();
    }
}
