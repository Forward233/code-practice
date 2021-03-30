package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2021/3/30 14:36
 * @Description:
 */
public class LetterCombinations {

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> res = letterCombinations.letterCombinations("23");
        System.out.println(res);
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] chars = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, chars, 0);
        return res;
    }

    private void dfs(String digits, String[] chars, int cur) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        //   '0'转为 int
        String str = chars[digits.charAt(cur) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits, chars, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
