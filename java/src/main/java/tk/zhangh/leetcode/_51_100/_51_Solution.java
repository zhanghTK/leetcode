package tk.zhangh.leetcode._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens
 * Created by ZhangHao on 2017/9/13.
 */
public class _51_Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        search(results, new ArrayList<>(), n);
        return results;
    }

    private void search(List<List<String>> results, List<Integer> result, int n) {
        if (result.size() == n) {
            results.add(drawChessboard(result));
            return;
        }
        // 深搜, result[x]=y表示x行y列
        for (int i = 0; i < n; i++) {
            if (isValid(result, i)) {
                result.add(i);
                search(results, result, n);
                result.remove(result.size() - 1);
            }
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');  // 当前列是皇后所在列
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(List<Integer> result, int index) {
        int row = result.size();
        for (int i = 0; i < result.size(); i++) {
            // 与前面所有行不重复
            if (result.get(i) == index) {
                return false;
            }
            // 对角线不重复
            if (i + result.get(i) == row + index) {
                return false;
            }
            if (i - result.get(i) == row - index) {
                return false;
            }
        }
        return true;
    }
}
