package tk.zhangh.leetcode.easy;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Created by ZhangHao on 2017/5/2.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int counter = 0, candidate = nums[0];
        for (int num : nums) {
            if (counter == 0) {
                candidate = num;
                counter = 1;
            } else if (candidate == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return candidate;
    }
}
