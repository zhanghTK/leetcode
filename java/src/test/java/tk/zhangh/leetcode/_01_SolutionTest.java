package tk.zhangh.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by ZhangHao on 2017/9/4.
 */
public class _01_SolutionTest {
    @Test
    public void twoSum() throws Exception {
        _01_Solution solution = new _01_Solution();
        assertArrayEquals(solution.twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        assertArrayEquals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    }
}