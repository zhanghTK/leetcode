package tk.zhangh.leetcode.tree;

import org.junit.Test;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class PostOrderTest extends VisitTreeTest {
    @Test
    public void recursionVisit() throws Exception {
        new PostOrder().recursionVisit(root);
    }

    @Test
    public void traversalVisit() throws Exception {
        new PostOrder().traversalVisit(root);
    }

}