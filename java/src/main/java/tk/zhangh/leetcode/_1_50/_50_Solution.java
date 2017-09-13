package tk.zhangh.leetcode._1_50;

/**
 * Pow(x, n)
 * Created by ZhangHao on 2017/9/13.
 */
public class _50_Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half / x * half;
        }
    }
}
