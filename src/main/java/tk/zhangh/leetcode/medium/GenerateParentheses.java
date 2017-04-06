package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Created by ZhangHao on 2017/4/6.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        generateParenthesis0(result, "", n, n);
        return result;
    }

    private void generateParenthesis0(List<String> result, String paren, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }
        if (left > 0) {
            generateParenthesis0(result, paren + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            generateParenthesis0(result, paren + ")", left, right - 1);
        }
    }
}
