package com.structure.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 11:26
 * @Description:
 */
public class TreeSearch {


    public static void main(String[] args) {
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
        TreeSearch treeSearch = new TreeSearch();
        //treeSearch.depthFirstSearch(root);
        treeSearch.depthFirstSearchWithStack(root);
        System.out.println();
//        treeSearch.breadthFirstSearchWithStack(root);

    }

    /*
     *                  1
     *            2            3
     *        4          5          6
     *            7             8      9
     */
    //  深度优先遍历 递归  1 2 4 7 3 5 6 8 9
    public void depthFirstSearch(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            depthFirstSearch(node.leftNode);
            depthFirstSearch(node.rightNode);
        }
    }

    /**
     * 深度优先遍历 栈
     * @param node
     */
    public void depthFirstSearchWithStack(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            // stack先进后出，所以rightNode先入栈
            if (treeNode.rightNode != null) {
                stack.push(treeNode.rightNode);
            }
            if (treeNode.leftNode != null) {
                stack.push(treeNode.leftNode);
            }
        }
    }



    /*
     *                  1
     *            2            3
     *        4          5          6
     *            7             8      9
     */
    // 广度优先遍历 队列
    public void breadthFirstSearchWithStack(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.val + " ");
            // 队列先进先出，所以rightNode先入栈
            if (treeNode.leftNode != null) {
                queue.add(treeNode.leftNode);
            }
            if (treeNode.rightNode != null) {
                queue.add(treeNode.rightNode);
            }
        }
    }
}
