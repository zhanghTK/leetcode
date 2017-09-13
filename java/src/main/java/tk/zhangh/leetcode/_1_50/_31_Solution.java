package tk.zhangh.leetcode._1_50;

/**
 * Next Permutation
 * Created by ZhangHao on 2017/9/7.
 */
public class _31_Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i;
        // 从右向左找到第一个递减的数：nums[i] < nums[i+1]
        for (i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--) ;
        // 在s[i+1:n-1]中找一个j，使s[j]>s[i]>=s[j+1]，swap(s[i], s[j])
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            j--;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        // 将s[i+1:n-1]排序，从低位到高位单调递减。
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
