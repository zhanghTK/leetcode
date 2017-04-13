package tk.zhangh.leetcode.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Created by ZhangHao on 2017/4/11.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(i + nums[i], reach);
        }
        return i == nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 1, 4}));
    }
}
