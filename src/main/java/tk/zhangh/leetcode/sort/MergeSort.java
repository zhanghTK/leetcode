package tk.zhangh.leetcode.sort;

/**
 * 归并排序
 * Created by ZhangHao on 2017/4/26.
 */
public class MergeSort implements Sort {
    private static void internalMergeSort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(a, b, left, middle);
            internalMergeSort(a, b, middle + 1, right);
            mergeSortedArray(a, b, left, middle, right);
        }
    }

    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
        int leftIndex = left;
        int rightIndex = middle + 1;
        int tempArrIndex = 0;
        while (leftIndex <= middle && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempArrIndex++] = arr[leftIndex++];
            } else {
                temp[tempArrIndex++] = arr[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            temp[tempArrIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempArrIndex++] = arr[rightIndex++];
        }
        for (leftIndex = 0; leftIndex < tempArrIndex; ++leftIndex) {
            arr[left + leftIndex] = temp[leftIndex];
        }
    }

    public static void main(String[] args) {
        int a[] = {8, 2, 3, 4, 3, 6, 6, 3, 9};

        System.out.printf("before sort:");
        printArray(a);
        new MergeSort().sort(a);

        System.out.printf("after  sort:");
        printArray(a);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) System.out.printf("%d ", num);
        System.out.printf("\n");
    }

    @Override
    public void sort(int[] nums) {
        int[] temp = new int[nums.length];
        internalMergeSort(nums, temp, 0, nums.length - 1);
    }
}
