package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class AddDigits {
    // http://www.cnblogs.com/grandyang/p/4741028.html
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
