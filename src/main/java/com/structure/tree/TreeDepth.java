package com.structure.tree;


/**
 * @author: yhl
 * @DateTime: 2021/1/14 11:21
 * @Description: 树的最长路径
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);

        root.leftNode = a;
        root.rightNode = b;
        a.leftNode = c;
        c.rightNode = f;
        b.leftNode = d;
        b.rightNode = e;
        e.leftNode = g;
        System.out.println(getMaxTreeDepth(root));
    }

    static int getMaxTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
//        int leftDepth = getMaxTreeDepth(node.leftNode) + 1;
//        int rightDepth = getMaxTreeDepth(node.rightNode) + 1;
        int leftDepth = getMaxTreeDepth(node.leftNode);
        int rightDepth = getMaxTreeDepth(node.rightNode);
        int max = Math.max(leftDepth, rightDepth);
        return max + 1;
    }
}
