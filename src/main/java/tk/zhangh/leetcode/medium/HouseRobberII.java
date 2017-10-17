package tk.zhangh.leetcode.medium;

/**
 * After robbing those houses on that street,
 * the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by ZhangHao on 2017/5/4.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        int containFirst = robSub(nums, 0, nums.length - 2);
        int containLast = robSub(nums, 1, nums.length - 1);
        return Math.max(containFirst, containLast);
    }

    private int robSub(int[] nums, int start, int end) {
        int local, maxPre = 0, max = 0;
        for (int i = start; i <= end; i++) {
            local = nums[i] + maxPre;
            maxPre = max;
            max = Math.max(max, local);
        }
        return max;
    }
}
