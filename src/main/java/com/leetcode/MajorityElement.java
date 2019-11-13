package com.leetcode;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2019/11/13 14:51
 * @Description:
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        final int e= new MajorityElement().majorityElement3(arr);
        System.out.println(e);
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     *  int[] arr = {2, 2, 1, 1, 1, 2, 2};
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int marjor = nums[0], count = 1;
        for (int num : nums) {
            if (count == 0) {
                count++;
                marjor = num;
            } else if (marjor == num) {
                count++;
            } else {
                count--;
            }
        }
        return marjor;
    }
}
