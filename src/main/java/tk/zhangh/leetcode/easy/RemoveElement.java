package tk.zhangh.leetcode.easy;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Created by ZhangHao on 2017/4/7.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int end = nums.length - 1;
        while (i <= end) {
            if (nums[i] == val) {
                nums[i] = nums[end--];
            } else {
                i++;
            }
        }
        return end + 1;
    }
}
