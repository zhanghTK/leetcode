package tk.zhangh.leetcode._1_50;

import org.junit.Test;

/**
 * Created by ZhangHao on 2017/9/11.
 */
public class _32_SolutionTest {
    @Test
    public void longestValidParentheses() throws Exception {
        System.out.println(new _32_Solution().longestValidParentheses(")()())"));
        System.out.println(new _32_Solution().longestValidParentheses("(()"));
        System.out.println(new _32_Solution().longestValidParentheses("()(())"));
    }

}