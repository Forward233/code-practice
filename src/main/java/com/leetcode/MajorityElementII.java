package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yhl
 * @DateTime: 2019/11/26 9:52
 * @Description:
 */
public class MajorityElementII {

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,2,2,2};
        final MajorityElementII majorityElementII = new MajorityElementII();
        System.out.println(majorityElementII.majorityElement(arr));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int first = 0, second = 0, count1 = 0, count2 = 0;
        // debug
        for (int num : nums) {
            if (num == first) {
                count1++;
            } else if (num == second) {
                count2++;
            } else if (count1 == 0) {
                first = num;
                count1++;
            } else if (count2 == 0) {
                second = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 可能有一个不满足要求，需再判断一下
        count1=0;
        count2=0;
        for (int num : nums) {
            if (num == first) {
                count1++;
            }else if (num == second) {
                count2++;
            }
        }
        if(count1 > length/3){
            list.add(first);
        }
        if(count2 > length/3){
            list.add(second);
        }
        return list;
    }
}
