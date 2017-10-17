package tk.zhangh.leetcode.medium;

import com.sun.rowset.providers.RIOptimisticProvider;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Created by ZhangHao on 17/4/9.
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};

        if (nums == null || nums.length == 0) {
            return ret;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                high = mid;
            } else if (target > nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (nums[low] == target) {
            ret[0] = low;
        } else if (nums[high] == target) {
            ret[0] = high;
        } else {
            return ret;
        }

        low = 0;
        high = nums.length - 1;

        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                low = mid;
            } else if (target > nums[mid]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        if (nums[high] == target) {
            ret[1] = high;
        } else if (nums[low] == target) {
            ret[1] = low;
        } else {
            return ret;
        }

        return ret;
    }
}
