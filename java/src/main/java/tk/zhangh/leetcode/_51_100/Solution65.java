package tk.zhangh.leetcode._51_100;

/**
 * Valid Number
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution65 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }

        boolean dotFlag = false;
        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '.':
                    if (dotFlag || // 小数点之前不能有小数点
                            eFlag || // 小数点之前不能有 e
                            ((i == 0 || !(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) &&  // 小数点不能是第一位
                                    (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')))) {  // 小数点不能是最后一位
                        return false;
                    }
                    dotFlag = true;
                    break;
                case '+':
                case '-':
                    if ((i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E'))  // 必须是第一位或者在e后面
                            || (i == s.length() - 1 || !(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' || s.charAt(i + 1) == '.'))) {  // 后面要有数字
                        return false;
                    }
                    break;
                case 'e':
                case 'E':
                    if (eFlag  // 前面不能出现过e
                            || i == s.length() - 1   // 不能是最后一位
                            || i == 0) {  // 不是第一位
                        return false;
                    }
                    eFlag = true;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                default:
                    return false;  // 其他情况不允许出现
            }
        }
        return true;
    }
}
