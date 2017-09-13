package tk.zhangh.leetcode._1_50;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/4.
 */
public class _03_SolutionTest {
    @Test
    public void lengthOfLongestSubstring() throws Exception {
        _03_Solution solution = new _03_Solution();
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
    }

}