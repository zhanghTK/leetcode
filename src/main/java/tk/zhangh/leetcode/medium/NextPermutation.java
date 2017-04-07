package tk.zhangh.leetcode.medium;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Created by ZhangHao on 2017/4/7.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i;
        for (i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
