package tk.zhangh.leetcode.sort;

/**
 * 堆排序
 * Created by ZhangHao on 2017/12/4.
 */
public class HeapSort implements Sort {
    public static void main(String[] args) {
        new HeapSort().testSort();
    }

    @Override
    public void sort(int[] data) {
        int length = data.length;
        // 遍历所有非叶子节点(叶子节点可以看作合法子堆)
        // 调整以非叶子节点为根的堆，生成大端堆
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(data, i, length);
        }
        // 依此从大端堆中取出根节点（最大值），再调整剩余元素为大端堆
        for (int len = data.length - 1; len >= 0; len--) {
            swap(data, 0, len);  // 将最大元素放到数组最后
            adjust(data, 0, len);  // 调整剩余部分的大端堆
        }
    }

    // 以parentIdx为根，以上向下调整堆
    // 前提parentIdx左/右子树已经是调整好的堆
    private void adjust(int[] nums, int parentIdx, int length) {
        int parentValue = nums[parentIdx];
        int childIdx = leftChildIdx(parentIdx);
        while (childIdx < length) {
            if (isRightGreaterLeft(nums, length, childIdx)) {
                childIdx++;
            }
            if (isParentGreaterChild(nums, parentValue, childIdx)) {
                break;
            }
            nums[parentIdx] = nums[childIdx];
            parentIdx = childIdx;
            childIdx = leftChildIdx(parentIdx);
        }
        nums[parentIdx] = parentValue;
    }

    private boolean isParentGreaterChild(int[] nums, int parent, int childIdx) {
        return parent > nums[childIdx];
    }

    private boolean isRightGreaterLeft(int[] ts, int length, int childIdx) {
        return childIdx + 1 != length && ts[childIdx + 1] > ts[childIdx];
    }

    private int leftChildIdx(int i) {
        return i * 2 + 1;
    }
}
