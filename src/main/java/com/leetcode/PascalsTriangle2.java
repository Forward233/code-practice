package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DateTime: 2019/11/11 21:27
 * Description: write some description
 * @author Yanhl
 */
public class PascalsTriangle2 {
    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle = new PascalsTriangle2();
        List<Integer> generate = pascalsTriangle.getRow2(1);
        System.out.println(generate);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result[j] = result[j] + result[j - 1];
            }
            result[i] = 1;
        }
        return Arrays.asList(result);
    }
}
