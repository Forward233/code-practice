package com.leetcode.arr;

import java.util.TreeSet;

/**
 * @author: yhl
 * @DateTime: 2021/4/17 8:35
 * @Description:
 */
public class ContainsNearbyAlmostDuplicate {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, 3, 0);
    }
    /**
     *
     * abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
