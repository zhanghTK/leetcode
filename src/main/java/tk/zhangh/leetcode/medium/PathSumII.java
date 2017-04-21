package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/20.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        findSum(rst, new ArrayList<>(), root, sum);
        return rst;
    }

    private void findSum(List<List<Integer>> results, List<Integer> result, TreeNode root, int sum){
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0){
                result.add(root.val);
                results.add(new ArrayList<>(result));
                result.remove(result.size()-1);
            }
            return;
        }
        result.add(root.val);
        findSum(results, result, root.left, sum);
        findSum(results, result, root.right, sum);
        result.remove(result.size()-1);
    }
}
