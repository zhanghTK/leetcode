package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/16.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{2, 2}));
    }

    // dp[i]表示以nums[i]为结尾的最长递增子串的长度，强行加入nums[i]了
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 以nums[i]为结尾的最长递增子串的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            // 找到dp[0]到dp[i-1]中最大的升序序列长度且nums[j]<nums[i]
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            // 加1就是该位置能构成的最长升序序列长度
            dp[i] += 1;
            // 更新全局长度
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
