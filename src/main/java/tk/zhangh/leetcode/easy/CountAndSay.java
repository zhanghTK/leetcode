package tk.zhangh.leetcode.easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Created by ZhangHao on 2017/4/10.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String oldStr = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] oldChars = oldStr.toCharArray();
            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count)).append(String.valueOf(oldChars[i]));
            }
            oldStr = sb.toString();
        }
        return oldStr;
    }

    public static void main(String[] args) {
        new CountAndSay().countAndSay(3);
    }
}
