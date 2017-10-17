package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/18.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j < num.length() - i - 1; j++) {
                String first = num.substring(0, i + 1);
                String second = num.substring(i + 1, j + 1);
                if (valid(j + 1, num, first, second))
                    return true;
            }
        }
        return false;
    }

    private boolean valid(int start, String num, String firstStr, String secondStr) {
        if (start == num.length())
            return true;
        long firstNum = Long.parseLong(firstStr);
        long secondNum = Long.parseLong(secondStr);
        if (!validNum(firstStr, firstNum) || !validNum(secondStr, secondNum))
            return false;
        long sumLong = firstNum + secondNum;
        String sumStr = Long.toString(sumLong);
        if (start + sumStr.length() > num.length())
            return false;
        String thirdStr = num.substring(start, start + sumStr.length());
        long thirdNum = Long.parseLong(thirdStr);
        return !(!validNum(thirdStr, thirdNum) || thirdNum != sumLong) && valid(start + sumStr.length(), num, secondStr, thirdStr);
    }

    private boolean validNum(String firstStr, long firstLong) {
        return Long.toString(firstLong).equals(firstStr);
    }
}
