package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yhl
 * @DateTime: 2021/3/20 13:47
 * @Description: 重复的DNA序列
 */
public class FindRepeatedDnaSequences {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new FindRepeatedDnaSequences().findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        Set<String> temp = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (temp.contains(sub)) {
                res.add(sub);
            } else {
                temp.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
}
