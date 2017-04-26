package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/26.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        new FindPeakElement().findPeakElement(new int[]{1});
    }

    public int findPeakElement(int[] nums) {
        for (int min = 0, max = nums.length - 1, mid = max / 2; min < max; mid = (min + max) / 2) {
            if (min == mid) {
                return nums[min] < nums[max] ? max : min;
            }
            min = nums[mid] < nums[mid + 1] ? mid : min;
            max = nums[mid] > nums[mid + 1] ? mid : max;
        }
        return 0;
    }
}
