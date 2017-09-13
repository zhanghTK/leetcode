package tk.zhangh.leetcode._1_50;

import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 * Created by ZhangHao on 2017/9/13.
 */
public class _46_Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, new LinkedList<>(), result, used);
        return result;
    }

    private void helper(int[] nums, List<Integer> result, List<List<Integer>> results, boolean[] used) {
        if (result.size() == nums.length) {
            // 找到
            List<Integer> list = new LinkedList<>(result);
            results.add(list);
        } else {
            // 深搜
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                result.add(nums[i]);
                helper(nums, result, results, used);
                result.remove(result.size() - 1);
                used[i] = false;
            }
        }
    }
}
