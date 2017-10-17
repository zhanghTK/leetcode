package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
