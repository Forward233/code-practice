package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2019/11/25 15:59
 * @Description:
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99};SingleNumber2 singleNumber = new SingleNumber2();
        System.out.println(singleNumber.singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num :nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if(count == 3){
                map.remove(num);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

    public int singleNumber2(int[] nums) {
        return 0;
    }

    public int singleNumber3(int[] nums) {
        return 0;
    }
}
