package tk.zhangh.leetcode.tree;

import org.junit.Test;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class InOrderTest extends VisitTreeTest {
    @Test
    public void recursionVisit() throws Exception {
        new InOrder().recursionVisit(root);
    }

    @Test
    public void traversalVisit() throws Exception {
        new InOrder().traversalVisit(root);
    }

}