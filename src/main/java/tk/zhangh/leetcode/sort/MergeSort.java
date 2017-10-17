package tk.zhangh.leetcode.sort;

/**
 * 归并排序
 * Created by ZhangHao on 2017/4/26.
 */
public class MergeSort implements Sort {
    public static void main(String[] args) {
        new MergeSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        mergeSort(data, new int[data.length], 0, data.length - 1);
    }

    private void mergeSort(int[] nums, int[] helpArray, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, helpArray, start, middle);
            mergeSort(nums, helpArray, middle + 1, end);
            mergeSortedArray(nums, helpArray, start, middle, end);
        }
    }

    private void mergeSortedArray(int nums[], int helpArray[], int start, int middle, int end) {
        int leftIndex = start;
        int rightIndex = middle + 1;
        int helpArrIndex = 0;
        while (leftIndex <= middle && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                helpArray[helpArrIndex++] = nums[leftIndex++];
            } else {
                helpArray[helpArrIndex++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= middle) {
            helpArray[helpArrIndex++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            helpArray[helpArrIndex++] = nums[rightIndex++];
        }

        System.arraycopy(helpArray, 0, nums, start, helpArrIndex);
    }
}
