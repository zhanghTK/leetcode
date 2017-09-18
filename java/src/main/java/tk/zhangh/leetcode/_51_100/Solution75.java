package tk.zhangh.leetcode._51_100;

/**
 * Sort Colors
 * Created by ZhangHao on 2017/9/18.
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);  // 把0交换到最前面
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, right, index);  // 把2交换到最后面
                right--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
