package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Created by ZhangHao on 2017/5/5.
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || n < 1) {
            return res;
        }
        rec(res, new ArrayList<>(), 0, k, n, 1);
        return res;
    }

    private void rec(List<List<Integer>> results, List<Integer> result, int sum, int k, int n, int index) {
        if (sum == n && k == 0) {
            results.add(new ArrayList<>(result));
            return;
        } else if (sum > n || k <= 0) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            result.add(i);
            rec(results, result, sum + i, k - 1, n, i + 1);
            result.remove(result.size() - 1);
        }
    }
}
