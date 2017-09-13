package tk.zhangh.leetcode._1_50;

/**
 * Median of Two Sorted Arrays
 * Created by ZhangHao on 2017/9/5.
 */
public class _04_Solution {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        int len = nums1.length + nums2.length;
        // 寻找第 k 小 的数字
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2)
                    + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 第 k 小的数在 nums2 中
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        // 第 k 小的数在 nums1 中
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 分别在 nums1 和 nums2 中找第 k/2 小的数
        int key1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        return key1 < key2 ?
                // nums1[0, key1] 全部比第 k 小的数小
                findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2) :
                // nums2[0, key2] 全部比第 k 小的数小
                findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
}
