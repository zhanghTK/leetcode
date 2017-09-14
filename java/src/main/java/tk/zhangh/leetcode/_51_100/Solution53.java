package tk.zhangh.leetcode._51_100;

/**
 * Maximum Subarray
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // DP
        int global = nums[0];  // 全局最优解
        int local = nums[0];  // 局部最优解
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
