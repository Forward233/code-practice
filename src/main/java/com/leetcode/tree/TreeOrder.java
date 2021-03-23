package com.leetcode.tree;

import com.structure.tree.TreeNode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/3/22 6:50
 * @Description:
 */
public class TreeOrder {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        TreeOrder treeOrder = new TreeOrder();
        int[][] res = treeOrder.threeOrders(treeNode);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int flag = 0, flag1 = 0, flag2 = 0;

    public int[][] threeOrders(TreeNode root) {
        // write code here
        int[][] nums = new int[3][getRootSize(root)];
        getRootVal(root, nums);
        return nums;
    }

    // [[1,2,3],[2,1,3],[2,3,1]]
    public void getRootVal(TreeNode root, int[][] nums) {
        if (root == null) {
            return;
        }
        nums[0][flag++] = root.val;
        getRootVal(root.left, nums);
        nums[1][flag1++] = root.val;
        getRootVal(root.right, nums);
        nums[2][flag2++] = root.val;
    }

    public int getRootSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getRootSize(root.left) + getRootSize(root.right);
    }
}
