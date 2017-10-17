package tk.zhangh.leetcode.hard;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * Created by ZhangHao on 2017/4/10.
 */
// todo
public class TrappingRainWater {
    public int trapRainWater(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int max = 0;
        int res = 0;
        int[] container = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            container[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            container[i] = Math.min(max, container[i]);
            max = Math.max(max, height[i]);
            res += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        new TrappingRainWater().trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}
