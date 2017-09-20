package tk.zhangh.leetcode._51_100;

/**
 * Search in Rotated Sorted Array II
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution81 {
    // 二分变体
    // 在 3,1,2,3,3,3,3 中找1/2，二分无法确定如何移动
    // target < nums[mid] 时，二分直接 high = mid -1， 但在5 6 7 8 9 1 2 3中查找2，会出错
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid])
                return true;
            if (nums[low] < nums[mid]) {
                // 前半段有序
                if (nums[mid] > target && nums[low] <= target) {
                    // 目标在有序的前半段
                    high = mid - 1;
                } else {
                    // 目标不在有序的前半段
                    low = mid + 1;
                }
            } else if (nums[low] > nums[mid]) {
                // 前半段无序
                if (nums[mid] < target && nums[high] >= target) {
                    // 目标在有序的后半段
                    low = mid + 1;
                } else {
                    // 目标不在有序的后半段
                    high = mid - 1;
                }
            } else {
                // 无法确定，逼近
                low++;
            }
        }
        return false;
    }
}
