package tk.zhangh.leetcode;

/**
 * Search in Rotated Sorted Array
 * Created by ZhangHao on 2017/9/11.
 */
public class _33_Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target == nums[m]) {
                return m;
            }
            if (nums[m] < nums[r]) {
                // [m,r]区间有序
                if (target > nums[m] && target <= nums[r]) {
                    // 目标在[m+1,r]区间
                    l = m + 1;
                } else {
                    // 目标在[l,m-1]区间
                    r = m - 1;
                }
            } else {
                // [l,m]区间有序
                if (target >= nums[l] && target <= nums[m]) {
                    // 目标在[l,m-1]区间
                    r = m - 1;
                } else {
                    // 目标在[m+1, r]区间
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}
