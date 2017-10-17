package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for (int num : nums) {
            if ((lastBit & num) == 0) {
                group0 ^= num;
            } else {
                group1 ^= num;
            }
        }

        return new int[]{group0, group1};
    }
}
