package com.leetcode.backtracking;

import com.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 15:06
 * @Description: 路径总和
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode1();
        PathSum pathSum = new PathSum();
        List<List<Integer>> result = pathSum.pathSum(root, 18);
        System.out.println(result);
    }

    /**
     *
     *                  1
     *            2            3
     *        4          5          6
     *            7             8      9
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subRes = new ArrayList<>();
        dsf(root, targetSum, subRes, res);
        return res;
    }

    private void dsf(TreeNode root, int sum, List<Integer> subRes, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        subRes.add(root.val);
        if (root.left == null  && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(subRes));
            }
            subRes.remove(subRes.size() - 1);
            return;
        }
        dsf(root.left, sum - root.val, subRes, res);
        dsf(root.right, sum - root.val, subRes, res);
        subRes.remove(subRes.size() - 1);
    }
}
