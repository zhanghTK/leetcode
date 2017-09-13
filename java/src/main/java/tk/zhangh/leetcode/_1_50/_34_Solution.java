package tk.zhangh.leetcode._1_50;

/**
 * Search for a Range
 * Created by ZhangHao on 2017/9/11.
 */
public class _34_Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int ll = 0;
        int lr = nums.length - 1;
        // 向左夹逼
        while (ll <= lr) {
            int m = (ll + lr) / 2;
            if (nums[m] < target) {
                ll = m + 1;
            } else {
                // 大于等于时，都取左区间
                lr = m - 1;
            }
        }
        int rl = 0;
        int rr = nums.length - 1;
        // 向右夹逼
        while (rl <= rr) {
            int m = (rl + rr) / 2;
            if (nums[m] <= target) {
                // 小于等于时，都取右区间
                rl = m + 1;
            } else {
                rr = m - 1;
            }
        }
        if (ll <= rr) {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }
}
