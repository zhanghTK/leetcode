package tk.zhangh.leetcode.sort;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class SelectSort implements Sort {
    public static void main(String[] args) {
        new SelectSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }
}
