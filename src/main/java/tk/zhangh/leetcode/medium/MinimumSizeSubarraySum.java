package tk.zhangh.leetcode.medium;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * Created by ZhangHao on 2017/5/4.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 3}));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, sum = 0, minLen = nums.length + 1;
        while (end <= nums.length && start <= end) {
            if (sum < s) {
                // 当右边界等于长度时，我们要多等一轮，等待左边界左移，这时候不能加
                if (end < nums.length) {
                    sum += nums[end];
                }
                end++;
            } else {
                // 当和大于等于目标时，检查长度并左移边界
                minLen = Math.min(minLen, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return minLen <= nums.length ? minLen : 0;
    }
}
