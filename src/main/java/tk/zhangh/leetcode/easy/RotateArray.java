package tk.zhangh.leetcode.easy;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Created by ZhangHao on 2017/5/3.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(ints, 3);
        System.out.println(Arrays.toString(ints));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0, j = nums.length - k - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = nums.length - k, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
