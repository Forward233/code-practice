package com.leetcode;

import com.structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 13:51
 * @Description:
 */
public class LevelOrder {


    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTreeNode1();
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrderWithDfs(treeNode);
        System.out.println(lists);
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderWithBfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                subRes.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(subRes);
        }
        return res;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderWithDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderWithDfs(res, root, 0);
        return res;
    }

    private void levelOrderWithDfs(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        levelOrderWithDfs(list, root.left, level + 1);
        levelOrderWithDfs(list, root.right, level + 1);
    }
}
