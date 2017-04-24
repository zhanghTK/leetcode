package tk.zhangh.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class LRUCache {
    int size;
    int capacity;
    ListNode tail;
    ListNode head;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode n = map.get(key);
        if (n != null) {
            moveToHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        ListNode n = map.get(key);
        if (n == null) {
            n = new ListNode(value, key);
            attachToHead(n);
            size++;
        } else {
            n.val = value;
            moveToHead(n);
        }
        // 如果更新节点后超出容量，删除最后一个
        if (size > capacity) {
            removeLast();
            size--;
        }
        map.put(key, n);
    }

    private void attachToHead(ListNode n) {
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    private void moveToHead(ListNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        attachToHead(n);
    }

    private void removeLast() {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }

    public class ListNode {
        ListNode prev;
        ListNode next;
        int val;
        int key;

        public ListNode(int v, int k) {
            this.val = v;
            this.prev = null;
            this.next = null;
            this.key = k;
        }
    }
}
