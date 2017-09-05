package tk.zhangh.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/5.
 */
public class _08_SolutionTest {
    @Test
    public void myAtoi() throws Exception {
        assertEquals(123, new _08_Solution().myAtoi("123"));
        assertEquals(-123, new _08_Solution().myAtoi("-123"));
    }

}