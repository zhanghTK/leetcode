package tk.zhangh.leetcode._1_50;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHao on 2017/9/5.
 */
public class _04_SolutionTest {
    @Test
    public void findMedianSortedArrays() throws Exception {
        assertEquals(new _04_Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0, 0.1);
        assertEquals(new _04_Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5, 0.1);
    }

}