package tk.zhangh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/24.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
