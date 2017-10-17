package tk.zhangh.leetcode.medium;

import tk.zhangh.leetcode.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        RandomListNode copyNode = newHead;
        while (node != null) {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }
}
