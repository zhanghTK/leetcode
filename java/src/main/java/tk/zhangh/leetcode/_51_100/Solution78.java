package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetsRecursion(result, new ArrayList<>(), nums, 0);
        return result;
    }

    // [1，2，3]的解顺序
    // []
    // [1]
    // [1 2]
    // [1 2 3]
    // [1 3]
    // [2]
    // [2 3]
    // [3]
    private void subsetsRecursion(List<List<Integer>> results, List<Integer> result, int[] num, int start) {
        results.add(new ArrayList<>(result));  // 一组解
        for (int i = start; i < num.length; i++) {
            result.add(num[i]);
            subsetsRecursion(results, result, num, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
