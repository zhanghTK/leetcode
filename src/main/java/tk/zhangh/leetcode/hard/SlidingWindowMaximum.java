package tk.zhangh.leetcode.hard;

import java.util.LinkedList;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class SlidingWindowMaximum {
    // https://segmentfault.com/a/1190000003903509
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length + 1 - k];

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if ((i + 1) >= k) {
                result[i + 1 - k] = nums[deque.peek()];
            }
        }
        return result;
    }
}
