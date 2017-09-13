package tk.zhangh.leetcode._1_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum II
 * Created by ZhangHao on 2017/9/12.
 */
public class _40_Solution {
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
                helper(nums, target - nums[i], i + 1, result);  // 修改 index
                result.remove(result.size() - 1);  // 回滚
                // 跳过重复
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}
