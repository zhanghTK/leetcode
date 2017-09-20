package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        combineDfs(results, new ArrayList<>(), n, k, 1);
        return results;
    }

    private void combineDfs(List<List<Integer>> results, List<Integer> result, int n, int k, int start) {
        // 找到一组解
        if (result.size() == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        // 深搜
        for (int i = start; i <= n; i++) {
            result.add(i);
            combineDfs(results, result, n, k, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
