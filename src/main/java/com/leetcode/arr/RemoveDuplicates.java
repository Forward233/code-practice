package com.leetcode.arr;

/**
 * @author: yhl
 * @DateTime: 2021/4/6 10:09
 * @Description:
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 2, 2, 3};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int res = removeDuplicates.removeDuplicates(nums);
        System.out.println(res);
    }

    //    输入：nums = [1,1,1,2,2,3]
//    输出：5, nums = [1,1,2,2,3]
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}