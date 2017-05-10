package tk.zhangh.leetcode.hard;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }


    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        int x = peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
