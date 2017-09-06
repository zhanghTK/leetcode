package tk.zhangh.leetcode;

/**
 * Remove Duplicates from Sorted Array
 * Created by ZhangHao on 2017/9/6.
 */
public class _26_Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
