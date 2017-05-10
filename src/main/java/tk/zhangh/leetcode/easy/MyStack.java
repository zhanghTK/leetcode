package tk.zhangh.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZhangHao on 2017/5/9.
 */
public class MyStack {
    int size;
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
        this.size = 0;
    }

    // Push element x onto stack.
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        size++;
    }

    // Removes the element on top of the stack.
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int res = 0;
        // 将前面的数都offer进另一个队列，然后拿出最后一个数
        if (queue1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            res = queue2.poll();
        } else {
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            res = queue1.poll();
        }
        size--;
        return res;
    }

    // Get the top element.
    public int top() {
        if (size == 0) {
            return -1;
        }
        // 先执行pop
        int top = pop();
        // 然后将pop出来的数再塞回队列就行了
        if (queue1.isEmpty()) {
            queue2.offer(top);
        } else {
            queue1.offer(top);
        }
        // 注意size也要加1
        size++;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size == 0;
    }
}
