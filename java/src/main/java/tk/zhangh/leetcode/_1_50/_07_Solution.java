package tk.zhangh.leetcode._1_50;

/**
 * Reverse Integer
 * Created by ZhangHao on 2017/9/5.
 */
public class _07_Solution {
    public int reverse(int x) {
        // 边界条件
        if (x == Integer.MIN_VALUE)
            return 0;
        int num = Math.abs(x);
        int res = 0;
        while (num != 0) {
            // 溢出
            if (res > (Integer.MAX_VALUE - num % 10) / 10)
                return 0;
            res = res * 10 + num % 10;
            num /= 10;
        }
        // 符号
        return x > 0 ? res : -res;
    }
}
