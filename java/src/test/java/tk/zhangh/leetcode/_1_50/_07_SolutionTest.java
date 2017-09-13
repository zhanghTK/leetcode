package tk.zhangh.leetcode._1_50;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/5.
 */
public class _07_SolutionTest {
    @Test
    public void reverse() throws Exception {
        assertEquals(321, new _07_Solution().reverse(123));
        assertEquals(-123, new _07_Solution().reverse(-321));
    }

}