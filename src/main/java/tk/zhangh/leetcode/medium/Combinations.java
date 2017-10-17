package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Created by ZhangHao on 2017/4/17.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combineDfs(results, new ArrayList<>(), n, k, 1);
        return results;
    }

    private void combineDfs(List<List<Integer>> results, List<Integer> result, int n, int k, int start) {
        if (result.size() == k) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = start; i <= n; i++) {
            result.add(i);
            combineDfs(results, result, n, k, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
