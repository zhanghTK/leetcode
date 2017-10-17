package tk.zhangh.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N-Queens
 * Created by ZhangHao on 2017/4/11.
 */
public class NQueens {
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
        for (int i = 0; i < n; i++) {
            if (isValid(result, i)) {
                result.add(i);
                search(results, result, n);
                result.remove(result.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> result, int index) {
        int row = result.size();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == index) {
                return false;
            }
            if (i + result.get(i) == row + index) {
                return false;
            }
            if (i - result.get(i) == row - index) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
}
