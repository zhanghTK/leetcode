package tk.zhangh.leetcode._1_50;

/**
 * Container With Most Water
 * Created by ZhangHao on 2017/9/5.
 */
public class _11_Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            maxArea = Math.max(area, maxArea);
            if (height[start] < height[end]) {
                // 左边低，调整
                start++;
            } else {
                // 右边低或左右相等，调整
                end--;
            }
        }
        return maxArea;
    }
}
