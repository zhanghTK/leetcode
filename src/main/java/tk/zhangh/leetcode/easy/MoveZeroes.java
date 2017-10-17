package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/15.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        for (; pos < nums.length; pos++) {
            nums[pos] = 0;
        }
    }
}
