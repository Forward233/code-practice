package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: yhl
 * @DateTime: 2019/11/26 14:43
 * @Description:
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        FindtheDuplicateNumber number = new FindtheDuplicateNumber();
        System.out.println(number.findDuplicate4(arr));
        String s = "1.txt";
        System.out.println(s.lastIndexOf("."));
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return num;
            }
            numSet.add(num);
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
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
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    /**
     * 用当前数字做索引，定位到元素位置，将数字置为负数(做别的标记也可以)，
     * 继续循环，如果此元素再次被定位到且为负数，说明此元素索引对应的元素出现过
     *
     * @param nums
     * @return
     */
    public int findDuplicate4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            }
        }
        return -1;
    }
}
