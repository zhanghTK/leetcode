package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/25.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                min = Math.min(nums[left], min);
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                min = Math.min(nums[mid], min);
                right = mid - 1;
            } else {
                left++;
            }
        }
        min = Math.min(nums[right], min);
        min = Math.min(nums[left], min);
        return min;
    }
}
