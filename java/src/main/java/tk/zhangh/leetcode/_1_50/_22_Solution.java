package tk.zhangh.leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/9/6.
 */
public class _22_Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n < 0) {
            return results;
        }
        generateParenthesis0(results, "", n, n);
        return results;
    }

    private void generateParenthesis0(List<String> results, String paren, int left, int right) {
        if (left == 0 && right == 0) {
            results.add(paren);
            return;
        }
        if (left > 0) {
            generateParenthesis0(results, paren + "(", left - 1, right);
        }
        //  注意 left < right
        // 确保左括号在右括号前
        if (right > 0 && left < right) {
            generateParenthesis0(results, paren + ")", left, right - 1);
        }
    }
}
