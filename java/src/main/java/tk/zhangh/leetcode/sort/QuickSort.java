package tk.zhangh.leetcode.sort;

/**
 * 快速排序
 * Created by ZhangHao on 2017/12/4.
 */
public class QuickSort implements Sort {
    public static void main(String[] args) {
        new QuickSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    // 以基准元素
    private void sort(int[] number, int left, int right) {
        if (left < right) {
            int partition = partition(number, left, right);
            sort(number, left, partition - 1);
            sort(number, partition + 1, right);
        }
    }

    private int partition(int[] data, int left, int right) {
        int key = data[left];  // 选取数组首元素作为基准
        // 由两端逼近，遍历所有元素
        while (left < right) {
            // 确保基准索引后不存在小于基准的元素
            while (left < right && data[right] >= key) {
                right--;
            }
            if (data[right] < key) {
                data[left++] = data[right];
            }
            // 确保基准索引前不存在大于基准的元素
            while (left < right && data[left] <= key) {
                left++;
            }
            if (data[left] > key) {
                data[right--] = data[left];
            }
        }
        data[left] = key;
        return left;
    }
}
