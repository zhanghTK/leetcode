package tk.zhangh.leetcode;

/**
 * Created by ZhangHao on 2017/9/6.
 */
public class _29_Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int symbol = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
        long x = Math.abs(((long) dividend));
        long y = Math.abs(((long) divisor));
        int result = 0;
        while (x >= y) {
            int shift = 0;
            // TODO
            while (x >= (y << shift)) {
                shift++;
            }
            x -= y << (shift - 1);
            result += 1 << (shift - 1);
        }
        return result * symbol;
    }
}
