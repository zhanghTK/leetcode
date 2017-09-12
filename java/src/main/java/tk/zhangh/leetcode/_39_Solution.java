package tk.zhangh.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum
 * Created by ZhangHao on 2017/9/12.
 */
public class _39_Solution {
    private List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);  // 排序
        helper(candidates, target, 0, new LinkedList<>());
        return results;
    }

    private void helper(int[] nums, int target, int index, List<Integer> result) {
        if (target == 0) {
            results.add(new LinkedList<>(result));
        } else if (target > 0) {
            for (int i = index; i < nums.length; i++) {
                result.add(nums[i]);  // 尝试 nums[i]
                helper(nums, target - nums[i], i, result);
                result.remove(result.size() - 1);  // 回滚
            }
        }
    }
}
