package tk.zhangh.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/5.
 */
public class _05_SolutionTest {
    @Test
    public void longestPalindrome() throws Exception {
        assertEquals("bab", new _05_Solution().longestPalindrome("babad"));
        assertEquals("bb", new _05_Solution().longestPalindrome("cbbd"));
    }

}