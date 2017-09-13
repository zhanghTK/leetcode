package tk.zhangh.leetcode._1_50;

/**
 * Count and Say
 * Created by ZhangHao on 2017/9/12.
 */
public class _38_Solution {
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
}
