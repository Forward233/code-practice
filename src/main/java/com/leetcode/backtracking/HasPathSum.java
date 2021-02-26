package com.leetcode.backtracking;

import com.structure.tree.TreeNode;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 10:10
 * @Description: 路径总和
 *
 * 区别：
 * ①递归是一种算法结构，而回溯和深搜是一种算法思想。
 * ②从解空间树的角度看，深搜会访问解空间树的所有节点，并标记“走过的路”（比如背包问题）不可撤销这种标记，一条路走到黑，直到找到问题的解；而回溯是一种试探性地行为，也会标记，但是可撤销此标记。
 * ③回溯和深搜最大的区别是回溯一定伴随着“剪枝”操作，节省大量时间，深搜却不一定。
 *
 * 联系：
 * ①回溯和深搜，本身就会利用到递归。
 * ②深搜可以看成是一种工具，回溯是这个工具的一种应用，换句话说，回溯是深搜的一种，深搜是回溯但不剪枝。
 *
 * 下面贴一下别的帖子找的
 * 回溯与深搜的关系
 * 回溯法的基本思想：
 * 在包含问题的所有解的解空间树中，按照深度优先搜索的策略，从根结点出发深度探索解空间树。当探索到某一结点时，要先判断该结点是否包含问题的解，
 * 如果包含，就从该结点出发继续探索下去，如果该结点不包含问题的解，则逐层向其祖先结点回溯。（其实回溯法就是对隐式图的深度优先搜索算法）。
 * 若用回溯法求问题的所有解时，要回溯到根，且根结点的所有可行的子树都要已被搜索遍才结束。 而若使用回溯法求任一个解时，只要搜索到问题的一个解就可以结束。
 */
public class HasPathSum {
    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        boolean res = hasPathSum.hasPathSum(treeNode, 3);
        System.out.println(res);
    }

    /**
     * 深度优先搜索 回溯
     *     1
     * 2       3
     * @param root
     * @param targetSum
     * @return
     */
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                res = true;
            }
        }
        // 剪枝
        if (!res) {
            dfs(node.left, sum - node.val);
        }
        if (!res) {
            dfs(node.right, sum - node.val);
        }
    }

}
