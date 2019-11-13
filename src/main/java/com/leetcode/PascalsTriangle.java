package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: yhl
 * DateTime: 2019/11/11 21:27
 * Description: write some description
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> generate = pascalsTriangle.generate(1);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arrList;
        if(numRows >= 1){
            arrList = new ArrayList<>();
            arrList.add(1);
            result.add(arrList);
        }
        if(numRows >= 2){
            arrList = new ArrayList<>();
            arrList.add(1);
            arrList.add(1);
            result.add(arrList);
        }

        for (int i = 0; i < numRows; i++) {
            int j = i - 1;
            arrList = new ArrayList<>();
            arrList.add(1);
            while (j >= 1) {
                arrList.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
                j--;
            }
            arrList.add(1);
            result.add(arrList);
        }
        return result;
    }
}
