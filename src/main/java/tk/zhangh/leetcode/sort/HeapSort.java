package tk.zhangh.leetcode.sort;

/**
 * 堆排序
 * Created by ZhangHao on 2017/4/26.
 */
public class HeapSort implements Sort {
    public static void main(String[] args) {
        new HeapSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        for (int length = data.length, i = length / 2 - 1; i >= 0; i--) {
            adjust(data, i, length);
        }
        for (int len = data.length - 1; len >= 0; len--) {
            swap(data, 0, len);
            adjust(data, 0, len);
        }
    }

    private void adjust(int[] nums, int parentIndex, int length) {
        int parentValue = nums[parentIndex];
        for (int childIndex = leftChildIndex(parentIndex);
             childIndex < length;
             parentIndex = childIndex, childIndex = leftChildIndex(parentIndex)) {
            if (isRightGreaterLeft(nums, length, childIndex)) {
                childIndex++;
            }
            if (isParentGreaterChild(nums, parentValue, childIndex)) {
                break;
            }
            nums[parentIndex] = nums[childIndex];
        }
        nums[parentIndex] = parentValue;
    }

    private boolean isParentGreaterChild(int[] nums, int parent, int childIndex) {
        return parent > nums[childIndex];
    }

    private boolean isRightGreaterLeft(int[] ts, int length, int childIndex) {
        return childIndex + 1 != length && ts[childIndex + 1] > ts[childIndex];
    }

    private int leftChildIndex(int i) {
        return i * 2 + 1;
    }
}
