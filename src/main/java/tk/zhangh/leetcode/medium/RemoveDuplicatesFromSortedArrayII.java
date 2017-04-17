package tk.zhangh.leetcode.medium;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * Created by ZhangHao on 2017/4/17.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int cur = 0;
        int i, j;
        for (i = 0; i < nums.length; i = j) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now)
                    break;
                if (j - i < 2)
                    nums[cur++] = now;
            }
        }
        return cur;
    }
}
