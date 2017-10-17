package tk.zhangh.leetcode.easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Created by ZhangHao on 2017/4/25.
 */
public class MinStack {
    private Stack<Integer> stk = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int x) {
        stk.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        int x = stk.pop();
        if (!min.isEmpty() && min.peek() == x) {
            min.pop();
        }
    }

    public int top() {
        if (!stk.isEmpty()) {
            return stk.peek();
        } else {
            return 0;
        }
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        } else {
            return 0;
        }
    }
}
