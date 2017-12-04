package tk.zhangh.leetcode.sort;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class ShellSort implements Sort {
    public static void main(String[] args) {
        new ShellSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int step = data.length / 2; step > 0; step /= 2) {
            for (int insertIndex = step; insertIndex < data.length; insertIndex++) {
                for (int i = insertIndex - step; i >= 0 && data[i] > data[i + step]; i -= step) {
                    swap(data, i, i + step);
                }
            }
        }
    }
}
