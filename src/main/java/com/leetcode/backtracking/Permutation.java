package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/3/6 12:40
 * @Description:
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] res = permutation.permutation("aab");
        System.out.println(Arrays.toString(res));
    }

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 1) {
            return new String[0];
        }
        List<String> path = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars,  res, path, used);
        return res.toArray(new String[0]);
    }

    private void dfs(char[] chars, List<String> res, List<String> path, boolean[] used) {
        if (path.size() == chars.length) {
            // 重点
            res.add(String.join("", path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(String.valueOf(chars[i]));
            used[i] = true;
            dfs(chars, res, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
