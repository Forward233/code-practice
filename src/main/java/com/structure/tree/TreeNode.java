package com.structure.tree;

/**
 * @author: yhl
 * @DateTime: 2021/1/14 11:22
 * @Description:
 *      *                  1
 *      *            2            3
 *      *        4          5          6
 *      *            7             8      9
 */
public class TreeNode {
    public int val;
    public TreeNode leftNode;
    public TreeNode rightNode;
    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode createTreeNode() {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);


        root.leftNode = a;
        root.rightNode = b;
        a.leftNode = c;
        c.rightNode = f;
        b.leftNode = d;
        b.rightNode = e;
        e.leftNode = g;
        e.rightNode = h;
        return root;
    }


    public TreeNode left;
    public TreeNode right;

    public static TreeNode createTreeNode1() {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(9);


        root.left = a;
        root.right = b;
        a.left = c;
        c.right = f;
        b.left = d;
        b.right = e;
        e.left = g;
        e.right = h;
        return root;
    }
}
