package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class powXY {
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
