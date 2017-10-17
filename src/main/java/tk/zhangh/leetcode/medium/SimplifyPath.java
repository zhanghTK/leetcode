package tk.zhangh.leetcode.medium;

import java.util.Stack;

/**
 * Created by ZhangHao on 2017/4/14.
 */
public class SimplifyPath {
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
