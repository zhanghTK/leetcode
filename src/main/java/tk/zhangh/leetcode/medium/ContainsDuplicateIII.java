package tk.zhangh.leetcode.medium;

import java.util.TreeSet;

/**
 * Created by ZhangHao on 2017/5/8.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 最大的小于x的数字
            if (set.ceiling(x) != null && set.ceiling(x) <= x + t) {
                return true;
            }
            // 最小的大于x的数字
//            if (set.floor(x) != null && x <= t + set.floor(x)) {
            if (set.floor(x) != null && set.floor(x) + t >= x) {
                return true;
            }
            set.add(x);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
