package tk.zhangh.leetcode._51_100;

/**
 * Add Binary
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        // a 比 b 长
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carries = 0;
        String result = "";
        // 先处理短字符串
        while (indexB >= 0) {
            int sum = a.charAt(indexA) - '0' + b.charAt(indexB) - '0' + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            indexA--;
            indexB--;
        }
        while (indexA >= 0) {
            int sum = a.charAt(indexA) - '0' + carries;
            result = String.valueOf(sum % 2) + result;
            carries = sum / 2;
            indexA--;
        }
        if (carries == 1) {
            result = "1" + result;
        }
        return result;
    }
}
