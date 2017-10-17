package tk.zhangh.leetcode.easy;

/**
 * Reverse digits of an integer.
 * Created by ZhangHao on 2017/4/5.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE)
            return 0;
        int num = Math.abs(x);
        int res = 0;
        while (num != 0) {
            if (res > (Integer.MAX_VALUE - num % 10) / 10)
                return 0;
            res = res * 10 + num % 10;
            num /= 10;
        }
        return x > 0 ? res : -res;
    }
}
