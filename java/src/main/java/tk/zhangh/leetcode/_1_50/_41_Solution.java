package tk.zhangh.leetcode._1_50;

/**
 * First Missing Positive
 * Created by ZhangHao on 2017/9/12.
 */
public class _41_Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
