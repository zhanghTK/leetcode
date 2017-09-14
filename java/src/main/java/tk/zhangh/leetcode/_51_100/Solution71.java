package tk.zhangh.leetcode._51_100;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start;
        int i = 0;

        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/') i++;
            start = i;
            while (i < path.length() && path.charAt(i) != '/') i++;

            if (i > start) {
                String part = path.substring(start, i);
                if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!part.equals(".")) {
                    stack.push(part);
                }
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
