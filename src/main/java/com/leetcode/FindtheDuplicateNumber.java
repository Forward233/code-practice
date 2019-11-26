package com.leetcode;

import java.util.*;

/**
 * @author: yhl
 * @DateTime: 2019/11/26 14:43
 * @Description:
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        FindtheDuplicateNumber number = new FindtheDuplicateNumber();
        System.out.println(number.findDuplicate3(arr));

    }

    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if(numSet.contains(num)){
                return num;
            }
            numSet.add(num);
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 3, 1, 3, 4, 2
     * round 1: slow = 3,
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
    }
}
