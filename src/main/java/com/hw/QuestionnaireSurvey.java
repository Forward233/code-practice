package com.hw;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: yhl
 * @DateTime: 2019/12/14 15:28
 * @Description:
 */
public class QuestionnaireSurvey {

    /**
     * 同一个测试用例里可能会有多组数据，希望大家能正确处理
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 不能结束输出
        while(sc.hasNext()){
            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }
}
