package tk.zhangh.leetcode._51_100;

/**
 * Sqrt(x)
 * Created by ZhangHao on 2017/9/18.
 */
public class Solution69 {
    public int mySqrt(int x) {
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (start + end) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end <= x) {
            return (int) end;
        }
        return (int) end;
    }
}
