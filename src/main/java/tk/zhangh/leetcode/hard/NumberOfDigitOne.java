package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class NumberOfDigitOne {
    // http://www.cnblogs.com/grandyang/p/4629032.html
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long r = n / i, m = n % i;
            count += (r + 8) / 10 * i + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }
}
