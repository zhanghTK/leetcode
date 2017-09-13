package tk.zhangh.leetcode._1_50;

/**
 * Trapping Rain Water
 * Created by ZhangHao on 2017/9/12.
 */
public class _42_Solution {
    // 计算左边
    // 计算右边
    // 比较左右，求较小
    // 较小的结果与height比较，累加正数
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int max = 0;
        int res = 0;
        int[] container = new int[height.length];
        // 第一次从左向右，更新每个bar左侧的最大高度
        // max 表示左边最大值
        for (int i = 0; i < height.length; i++) {
            container[i] = max;  // 更新左边最大值
            max = Math.max(max, height[i]);  // 左边最大值
        }
        max = 0;
        // 第二次从右向左，更新每个bar右侧的最大高度，并比较左右找出较小
        // max 表示右边最大值
        for (int i = height.length - 1; i >= 0; i--) {
            container[i] = Math.min(max, container[i]);  // 找出左右较小的最大值，max：右，container[i]：左
            max = Math.max(max, height[i]);  // 更新右边最大值
            res += container[i] - height[i] > 0 ? container[i] - height[i] : 0;  // 累加计算
        }
        return res;
    }
}
