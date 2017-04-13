package tk.zhangh.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Created by ZhangHao on 2017/4/10.
 */
public class CombinationSum {

    private List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new LinkedList<>());
        return results;
    }

    private void helper(int[] nums, int target, int index, List<Integer> result) {
        if (target == 0) {
            results.add(new LinkedList<>(result));
        }else if (target > 0 ) {
            for (int i = index; i < nums.length; i++) {
                result.add(nums[i]);
                helper(nums, target - nums[i], i, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
