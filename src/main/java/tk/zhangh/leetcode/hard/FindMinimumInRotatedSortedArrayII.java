package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/4/25.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        while (left < right - 1) {
            int m = (left + right) / 2;
            if (nums[left] < nums[m]) {
                min = Math.min(nums[left], min);
                left = m + 1;
            } else if (nums[left] > nums[m]) {
                min = Math.min(nums[m], min);
                right = m - 1;
            } else {
                left++;
            }
        }
        min = Math.min(nums[right], min);
        min = Math.min(nums[left], min);
        return min;
    }
}
