package tk.zhangh.leetcode.medium;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],the contiguous subarray [2,3] has the largest product = 6.
 * Created by ZhangHao on 2017/4/25.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxs = nums[0];
        int mins = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = maxs;
            maxs = max(nums[i] * maxs, nums[i], nums[i] * mins);
            mins = min(nums[i] * curMax, nums[i], nums[i] * mins);
            global = Math.max(global, maxs);
        }
        return global;
    }

    private int min(int... nums) {
        int result = nums[0];
        for (int num : nums) {
            if (num < result) {
                result = num;
            }
        }
        return result;
    }

    private int max(int... nums) {
        int result = nums[0];
        for (int num : nums) {
            if (num > result) {
                result = num;
            }
        }
        return result;
    }
}
