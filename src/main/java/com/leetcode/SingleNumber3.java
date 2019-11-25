package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2019/11/25 15:59
 * @Description:
 */
public class SingleNumber3 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,1,99};
        SingleNumber3 singleNumber = new SingleNumber3();
        System.out.println(Arrays.toString(singleNumber.singleNumber(arr)));

        Set<Integer> set = new HashSet<>();
        //Set-->数组
        Integer[] array=set.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));
    }

    public int[] singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer num :nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
            if(count == 2){
                map.remove(num);
            }
        }
        final Set<Integer> set = map.keySet();
        new ArrayList<>(set).toArray();
    }

    public int singleNumber2(int[] nums) {
        return 0;
    }

    public int singleNumber3(int[] nums) {
        return 0;
    }
}
