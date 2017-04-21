package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Created by ZhangHao on 2017/4/19.
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return results;
        helper(results, new ArrayList<>(), s, 0);
        return results;
    }

    private void helper(List<String> results, List<String> result, String s, int start) {
        if (result.size() == 4) {
            if (start != s.length())
                return;
            StringBuilder sb = new StringBuilder();
            for (String tmp : result) {
                sb.append(tmp);
                sb.append(".");
            }
            results.add(sb.deleteCharAt(sb.length() - 1).toString());
            return;
        }

        for (int i = start; i < s.length() && i < start + 3; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                result.add(tmp);
                helper(results, result, s, i + 1);
                result.remove(result.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return s.equals("0");
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
