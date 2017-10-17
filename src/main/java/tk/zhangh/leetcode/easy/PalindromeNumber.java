package tk.zhangh.leetcode.easy;

/**
 * Determine whether an integer is a palindrome.
 * Do this without extra space.
 * Created by ZhangHao on 2017/4/5.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int num = x;
        int reversal = 0;
        while (x != 0) {
            reversal = reversal * 10 + x % 10;
            x = x / 10;
        }
        return reversal == num;
    }
}
