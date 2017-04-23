package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 17/4/23.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        helper(s, 0, new ArrayList<>(), results);
        return results;
    }

    private void helper(String s, int startIndex, List<String> result, List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            result.add(subString);
            helper(s, i + 1, result, results);
            result.remove(result.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
