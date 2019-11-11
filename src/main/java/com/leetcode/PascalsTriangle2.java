package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yhl
 * DateTime: 2019/11/11 21:27
 * Description: write some description
 */
public class PascalsTriangle2 {
    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle = new PascalsTriangle2();
        for (int i = 0; i < 33 ; i++) {
            List<Integer> generate = pascalsTriangle.getRow(i);
            System.out.println(generate);
        }

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(){

                }
            }
            int j = i - 1;
            arrList = new ArrayList<>();
            arrList.add(1);
            while (j >= 1) {
                arrList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                j--;
            }
            arrList.add(1);
            result.add(arrList);
        }
        return result;
    }
}
