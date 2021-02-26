package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/2/26 9:53
 * @Description:
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(list);
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        // 剪枝
        if (open > n || close > open) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        dfs(n, path + "(", res, open + 1, close);
        dfs(n, path + ")", res, open, close + 1);
    }

    private void dfs2(int n, String path, List<String> res, int open, int close) {

        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        // 剪枝
        if (open < n) {
            dfs(n, path + "(", res, open + 1, close);
        }
        if (close < n) {
            dfs(n, path + ")", res, open, close + 1);
        }
    }

}
