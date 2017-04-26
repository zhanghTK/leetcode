package tk.zhangh.leetcode.sort;

/**
 * 快速排序
 * Created by ZhangHao on 2017/4/26.
 */
public class QuickSort implements Sort {
    private static void swap(int[] data, int low, int high) {
        int tmp = data[high];
        data[high] = data[low];
        data[low] = tmp;
    }

    public static void main(String[] args) {
        int i;
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        new QuickSort().sort(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] number, int left, int right) {
        if (left < right) {
            int partition = partition(number, left, right);
            sort(number, left, partition - 1);
            sort(number, partition + 1, right);
        }

    }

    private int partition(int[] data, int low, int high) {
        int key = data[low];
        while (low < high) {
            while (high > low && data[high] > key) {
                high--;
            }
            if (data[high] <= key) {
                swap(data, low, high);
            }
            while (high > low && data[low] <= key) {
                low++;
            }
            if (data[low] >= key) {
                int tmp = data[low];
                data[low] = data[high];
                data[high] = tmp;
            }
        }
        return low;
    }
}
