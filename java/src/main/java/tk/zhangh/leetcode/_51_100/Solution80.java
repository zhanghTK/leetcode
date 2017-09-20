package tk.zhangh.leetcode._51_100;

/**
 * Remove Duplicates from Sorted Array II
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;
        int cur = 0;
        int i, j;
        // i 是慢指针，j 是快指针
        // cur 标记当前结果
        for (i = 0; i < nums.length; i = j) {
            int now = nums[i];  // 记录新的值
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now)  // 找到新值
                    break;
                if (j - i < 2)  // 快慢指针最大差二
                    nums[cur++] = now;
            }
        }
        return cur;
    }
}
