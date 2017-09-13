package tk.zhangh.leetcode._1_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations II
 * Created by ZhangHao on 2017/9/13.
 */
public class _47_Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, new LinkedList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp, List<List<Integer>> result, boolean[] used) {
        if (tmp.size() == nums.length) {
            // 找到
            List<Integer> list = new LinkedList<>(tmp);
            result.add(list);
        } else {
            // 深搜
            for (int idx = 0; idx < nums.length; idx++) {
                if (used[idx]) {
                    continue;
                }
                used[idx] = true;
                tmp.add(nums[idx]);
                helper(nums, tmp, result, used);
                tmp.remove(tmp.size() - 1);
                used[idx] = false;
                // 跳过重复元素
                while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
                    idx++;
                }
            }
        }
    }
}
