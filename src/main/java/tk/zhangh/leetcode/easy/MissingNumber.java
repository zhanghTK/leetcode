package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        return n * (n + 1) / 2 - sum;
    }
}
