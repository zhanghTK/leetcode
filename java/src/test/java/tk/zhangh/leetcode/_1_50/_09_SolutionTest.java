package tk.zhangh.leetcode._1_50;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/5.
 */
public class _09_SolutionTest {
    @Test
    public void isPalindrome() throws Exception {
        assertEquals(true, new _09_Solution().isPalindrome(121));
        assertEquals(false, new _09_Solution().isPalindrome(123));
    }

}