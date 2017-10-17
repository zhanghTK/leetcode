package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/5.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }

    private int quickSelect(int nums[], int k, int left, int right) {
        int pivot = nums[(left + right) / 2];
        int orgL = left, orgR = right;
        while (left <= right) {
            while (nums[left] > pivot) {
                left++;
            }
            while (nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (orgL < right && k <= right) {
            return quickSelect(nums, k, orgL, right);
        }
        if (left < orgR && k >= left) {
            return quickSelect(nums, k, left, orgR);
        }
        return nums[k];
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    }
}
