package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Created by ZhangHao on 2017/4/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetsRecursion(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsetsRecursion(List<List<Integer>> results, List<Integer> result, int[] num, int start) {
        results.add(new ArrayList<>(result));
        for (int i = start; i < num.length; i++) {
            result.add(num[i]);
            subsetsRecursion(results, result, num, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
