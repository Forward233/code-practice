package com.structure.tree;

import java.util.Stack;

/**
 * @author: yhl
 * @DateTime: 2019/11/16 18:09
 * @reference : https://blog.csdn.net/wang454592297/article/details/79472938#commentsedit
 * @Description:
 */
public class TreeIter {

    private static class TreeNode{
        private int val;
        private TreeNode leftNode;
        private TreeNode rightNode;
        TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 前中后 是针对于根节点来说的
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 后序遍历：左子树 ---> 右子树 ---> 根结点
     * 层次遍历：只需按层次遍历即可
     */

    /*
     * 递归实现左、中、右遍历
     *                  1
     *             2         3
     *         4          5     6
     *             7         8
     */


    // 先序遍历
    void preorderTraversalByRecursion(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+" ");
            if(root.leftNode != null){
                preorderTraversalByRecursion(root.leftNode);
            }
            if(root.rightNode != null){
                preorderTraversalByRecursion(root.rightNode);
            }
        }
    }

                 /*                  1
                 *             2           3
                 *         4            5     6
                 *             7           8
                 */
    // 中序遍历
    void middleorderTraversalByRecursion(TreeNode root) {
        if (root != null) {
            if(root.leftNode != null){
                middleorderTraversalByRecursion(root.leftNode);
            }
            System.out.print(root.val+" ");
            if(root.rightNode != null){
                middleorderTraversalByRecursion(root.rightNode);
            }
        }
    }

    /*                  1
     *             2           3
     *         4            5     6
     *             7           8
     */
    // 后序遍历
    void postorderTraversalByRecursion(TreeNode root) {
        if (root != null) {
            if(root.leftNode != null){
                postorderTraversalByRecursion(root.leftNode);
            }
            if(root.rightNode != null){
                postorderTraversalByRecursion(root.rightNode);
            }
            System.out.print(root.val+" ");
        }
    }

    /**
     * 非递归遍历
     *
     */

    /*                  1
     *             2           3
     *         4            5     6
     *             7           8
     */
    // 中左右
    void preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.leftNode;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.rightNode;
            }
        }
    }

    /*                  1
     *             2           3
     *         4            5     6
     *             7           8
     */
    // 左中右
    void middleorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.leftNode;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.rightNode;
            }
        }
    }

    /*                  1
     *             2           3
     *         4            5     6
     *             7           8
     */
    // 左右中
    void postorderTraversal(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            boolean tag = true;
            TreeNode preNode = null;  // 前驱节点
            while (!stack.isEmpty() && tag) {
                treeNode = stack.peek();
                if (treeNode.rightNode == preNode) { // 之前访问的为空节点或是栈顶节点的右子节点
                    treeNode = stack.pop();
                    System.out.print(treeNode.val + " ");
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = treeNode;
                    }
                } else {
                    treeNode = treeNode.rightNode;
                    tag = false;
                }
            }
        }
    }


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

        TreeIter treeIter = new TreeIter();
        treeIter.preorderTraversalByRecursion(root);
        System.out.println();
        treeIter.preorderTraversal(root);
        System.out.println();
        treeIter.middleorderTraversalByRecursion(root);
        System.out.println();
        treeIter.middleorderTraversal(root);
        System.out.println();
        treeIter.postorderTraversalByRecursion(root);
        System.out.println();
        treeIter.postorderTraversal(root);
    }
}
