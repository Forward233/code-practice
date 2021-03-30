package com.leetcode.arr;

/**
 * @author: yhl
 * @DateTime: 2021/3/25 6:16
 * @Description: 颜色分类
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new SortColors().sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, cur = 0;
        while(cur <= right){
            if(nums[cur] == 0){
                swap(nums,cur++,left++);
            }
            else if(nums[cur] == 2){
                swap(nums,cur,right--);
            }
            else{
                cur++;
            }
        }
    }

    private void swap(int[] nums,int n,int m){
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
