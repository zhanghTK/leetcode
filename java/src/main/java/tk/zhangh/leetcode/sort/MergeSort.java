package tk.zhangh.leetcode.sort;

/**
 * 归并排序
 * Created by ZhangHao on 2017/12/4.
 */
public class MergeSort implements Sort {
    public static void main(String[] args) {
        new MergeSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            mergeSortedArray(nums, start, middle, end);
        }
    }

    private void mergeSortedArray(int nums[], int start, int middle, int end) {
        int[] helpArray = new int[nums.length];
        int leftIdx = start;
        int rightIdx = middle + 1;
        int helpArrIdx = 0;
        // 数组合并
        while (leftIdx <= middle && rightIdx <= end) {
            if (nums[leftIdx] <= nums[rightIdx]) {
                helpArray[helpArrIdx++] = nums[leftIdx++];
            } else {
                helpArray[helpArrIdx++] = nums[rightIdx++];
            }
        }
        while (leftIdx <= middle) {
            helpArray[helpArrIdx++] = nums[leftIdx++];
        }
        while (rightIdx <= end) {
            helpArray[helpArrIdx++] = nums[rightIdx++];
        }
        System.arraycopy(helpArray, 0, nums, start, helpArrIdx);
    }
}
