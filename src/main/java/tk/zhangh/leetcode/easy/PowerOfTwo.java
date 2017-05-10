package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt == 1;
    }
}
