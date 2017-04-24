package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                digits[i] += (nums[j] >> i) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (digits[i] % 3) << i;
        }
        return res;
    }
}
