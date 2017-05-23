package tk.zhangh.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by ZhangHao on 2017/5/16.
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxheap = new PriorityQueue<>();
        minheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }

    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double) (maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }
}
