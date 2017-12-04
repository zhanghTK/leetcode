package tk.zhangh.leetcode.tree;

import org.junit.BeforeClass;

/**
 * Created by ZhangHao on 2017/12/4.
 */
public class VisitTreeTest {
    static TreeNode root;

    @BeforeClass
    public static void createTree() {
        root = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(5);
        root.left = treeNode2;
        root.right = treeNode8;
        treeNode2.left = treeNode0;
        treeNode2.right = treeNode4;
        treeNode8.right = treeNode9;
        treeNode0.right = treeNode1;
        treeNode4.right = treeNode5;
    }
}