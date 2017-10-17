package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ver;
        while (low < high) {
            ver = low + (high - low) / 2;
            if (isBadVersion(ver)) {
                high = ver;
            } else {
                low = ver + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int ver) {
        return false;
    }
}
