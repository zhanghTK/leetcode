package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int n : left) {
                    for (int m : right) {
                        switch (ch) {
                            case '+':
                                result.add(n + m);
                                break;
                            case '-':
                                result.add(n - m);
                                break;

                            case '*':
                                result.add(n * m);
                                break;
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }

        return result;
    }
}
