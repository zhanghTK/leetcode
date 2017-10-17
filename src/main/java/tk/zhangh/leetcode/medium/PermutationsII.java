package tk.zhangh.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class PermutationsII {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, new LinkedList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp, List<List<Integer>> result, boolean[] used) {
        if (tmp.size() == nums.length) {
            List<Integer> list = new LinkedList<Integer>(tmp);
            result.add(list);
        } else {
            for (int idx = 0; idx < nums.length; idx++) {
                if (used[idx]) {
                    continue;
                }
                used[idx] = true;
                tmp.add(nums[idx]);
                helper(nums, tmp, result, used);
                tmp.remove(tmp.size() - 1);
                used[idx] = false;
                while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
                    idx++;
                }
            }
        }
    }
}
