package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, new LinkedList<>(), res, used);
        return res;
    }

    private void helper(int[] nums, List<Integer> result, List<List<Integer>> results, boolean[] used) {
        if (result.size() == nums.length) {
            List<Integer> list = new LinkedList<>(result);
            results.add(list);
        } else {
            for (int idx = 0; idx < nums.length; idx++) {
                if (used[idx]) {
                    continue;
                }
                used[idx] = true;
                result.add(nums[idx]);
                helper(nums, result, results, used);
                result.remove(result.size() - 1);
                used[idx] = false;
            }
        }
    }
}
