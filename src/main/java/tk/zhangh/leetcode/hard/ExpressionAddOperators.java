package tk.zhangh.leetcode.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/5/15.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> results = new LinkedList<>();
        addOperators(num, target, 0, 0, "", results);
        return results;
    }

    private void addOperators(String num, int target, long lastOp, long result, String expression, List<String> results) {
        if (num.length() == 0) {
            if (target == result) {
                results.add(expression);
            }
        }
        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            if (currStr.length() > 1 && currStr.charAt(0) == '0')
                continue;
            String rest = num.substring(i);
            long curNum = Long.parseLong(currStr);
            if (expression.length() == 0) {
                addOperators(rest, target, curNum, curNum, expression + currStr, results);
            } else {
                addOperators(rest, target, curNum, result + curNum, expression + "+" + currStr, results);
                addOperators(rest, target, -curNum, result - curNum, expression + "-" + currStr, results);
                addOperators(rest, target, curNum * lastOp, result - lastOp + lastOp * curNum, expression + "*" + currStr, results);
            }
        }
    }
}
