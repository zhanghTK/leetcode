package tk.zhangh.leetcode.medium;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * Created by ZhangHao on 2017/5/2.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, (n1, n2) -> (String.valueOf(n2) + String.valueOf(n1)).compareTo(String.valueOf(n1) + String.valueOf(n2)));
        if (sorted[0] == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (Integer num : sorted) {
            result.append(num);
        }
        return result.toString();
    }
}
