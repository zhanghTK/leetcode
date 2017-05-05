package tk.zhangh.leetcode.sort;

/**
 * 快速排序
 * Created by ZhangHao on 2017/4/26.
 */
public class QuickSort implements Sort {
    public static void main(String[] args) {
        new QuickSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] number, int left, int right) {
        if (left < right) {
            int partition = partition(number, left, right);
            sort(number, left, partition);
            sort(number, partition + 1, right);
        }

    }

    private int partition(int[] data, int low, int high) {
        int key = data[low];
        while (low < high) {
            high = swapMinInHighPartition(data, low, high, key);
            low = swapMaxInLowPartition(data, low, high, key);
        }
        return high;
    }

    private int swapMaxInLowPartition(int[] data, int low, int high, int key) {
        while (high > low && data[low] <= key) {
            low++;
        }
        if (data[low] >= key) {
            swap(data, low, high);
        }
        return low;
    }

    private int swapMinInHighPartition(int[] data, int low, int high, int key) {
        while (high > low && data[high] > key) {
            high--;
        }
        if (data[high] <= key) {
            swap(data, low, high);
        }
        return high;
    }
}
