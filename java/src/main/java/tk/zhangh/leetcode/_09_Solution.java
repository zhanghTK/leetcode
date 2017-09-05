package tk.zhangh.leetcode;

/**
 * Palindrome Number
 * Created by ZhangHao on 2017/9/5.
 */
public class _09_Solution {
    public boolean isPalindrome(int x) {
        // 特殊数字判断
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        // 反转
        int num = x;
        int reversal = 0;
        while (x != 0) {
            reversal = reversal * 10 + x % 10;
            x = x / 10;
        }
        return reversal == num;
    }
}
