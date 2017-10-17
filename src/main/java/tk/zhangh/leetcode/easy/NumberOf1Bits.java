package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/3.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
