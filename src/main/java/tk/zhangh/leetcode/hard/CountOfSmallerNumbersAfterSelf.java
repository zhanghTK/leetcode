package tk.zhangh.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/19.
 */
public class CountOfSmallerNumbersAfterSelf {
//    public List<Integer> countSmaller(int[] nums) {
//        int[] counter = new int[nums.length];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) counter[i]++;
//            }
//        }
//        List<Integer> counts = new ArrayList<>(counter.length);
//        for (int aSmaller : counter) counts.add(aSmaller);
//        return counts;
//    }

    public static void main(String[] args) {
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(new int[]{5, 2, 6, 1}));
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] smaller = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left <= right) {
                int m = (left + right) / 2;
                if (nums[i] > nums[m]) right = m - 1;
                else left = m + 1;
            }
            smaller[i] = nums.length - left;
            int temp = nums[i];
            System.arraycopy(nums, i + 1, nums, i, right - i);
            nums[right] = temp;
        }
        List<Integer> results = new ArrayList<>(nums.length);
        for (int aSmaller : smaller) results.add(aSmaller);
        return results;
    }
}
