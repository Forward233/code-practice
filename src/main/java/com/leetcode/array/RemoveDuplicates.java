package com.leetcode.array;

/**
 * Author: yhl
 * DateTime: 2019/11/4 15:16
 * Description: write some description
 */
public class RemoveDuplicates {
    public static void main(String[] args) {

        RemoveDuplicates duplicates = new RemoveDuplicates();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(duplicates.removeDuplicates(arr));

    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int j = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[j] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 0;
        for(int i=0; i<nums.length-1; i++)
            if(nums[i] != nums[i+1]) nums[++index] = nums[i+1];
        return index+1;
    }}
