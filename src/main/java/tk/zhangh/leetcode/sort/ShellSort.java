package tk.zhangh.leetcode.sort;

/**
 * 希尔排序
 * Created by ZhangHao on 2017/4/26.
 */
public class ShellSort implements Sort {
    public static void main(String[] args) {
        new ShellSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int step = data.length / 2; step > 0; step /= 2) {
            for (int insertIndex = step; insertIndex < data.length; insertIndex++) {
                for (int beforeInsertIndex = insertIndex - step;
                     beforeInsertIndex >= 0 && data[beforeInsertIndex] > data[beforeInsertIndex + step];
                     beforeInsertIndex -= step) {
                    swap(data, beforeInsertIndex, beforeInsertIndex + step);
                }
            }
        }
    }
}
