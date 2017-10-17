package tk.zhangh.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Created by ZhangHao on 2017/4/10.
 */
public class CombinationSumII {
    private List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<>());
        return results;
    }

    private void helper(int[] nums, int target, int index, List<Integer> result) {
        if (target == 0) {
            results.add(new LinkedList<>(result));
        } else if (target > 0) {
            for (int i = index; i < nums.length; i++) {
                result.add(nums[i]);
                helper(nums, target - nums[i], i + 1, result);
                result.remove(result.size() - 1);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}
