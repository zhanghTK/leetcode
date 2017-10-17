package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/18.
 */
public class NumArray {

    private long[] sum;

    public NumArray(int[] nums) {
        sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] += nums[i] + sum[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i > j || i < 0 || j >= sum.length - 1) {
            return Integer.MIN_VALUE;
        }
        return (int) (sum[j + 1] - sum[i]);
    }
}
