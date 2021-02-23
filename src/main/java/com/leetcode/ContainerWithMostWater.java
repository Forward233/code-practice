package com.leetcode;

/**
 * @author: yhl
 * @DateTime: 2020/1/6 13:53
 * @Description:
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {50,23,2,70,12,84,99,23,10,52,19,63,37,32,95,68,25,38,11,32,94,87,47,43,76,43,16,52,52,25,90,2,48,44,24,12,28,75,35,39,80,7,54,17,39,50,86,64,88,49,96,35,36,43,78,65,39,46,17,43,71,7,98,19,4,22,32,32,50,19,23,30,26,78,99,65,28,37,30,68,87,78,55,75,74,86,40,65,32,10,8,56,69,6,75,73,81,59,6,83,79,29,13,57,7,64,23,87,2,5,56,41,35,63,16,9,49,57,26,34,67,35,90,36,93,17,62,26,29,68,9,8,97,74,65,57,39,40,44,93,45,52,34,33,16,2,42,17,59,21,3,78,56,93,67,1,63,29,28,92,97,89,52,46,64,69,3,55,10,0,48,7,52,34,40,20,36,35,90,48,56,93,78,64,39,45,17,2,26,97,94,75,87,46,74,3,67,29,58,29,29,58,37,34,92,29,6,80,16,96,28,24,90,7,40,81,4,58,83,83,55,77,58,42,75,32,45,94,62,55,24,43,13,13,29,57,42,36,38,11,32,18,35,74,77,76,55,82,34,90,17,41,19,75,84,46,60,81,41,74,89,65,69,54,78,99,12,72,35,2,35,19,72,71,46,50,99,53,84,85,44,53,26,63,28,62,62,40,96,3,14,85,20,36,91,50,35,55,22,22,9,10,41,82,81,39,84,32,93,20,17,89,73,95,4,53,10,66,94,6,21,60,43,41,96,34,91,31,42,66,53,51,76,47,33,9,86,69,93,31,89,10,20,14,57,77,68,67,43,62,25,17,74,20,58,71,7,2,54,49,20,60,0,48,59,34,9,97,55,2,29,45,64,1,59,21,78,27,41,74,41,66,91,68,87,1,39,46,3,45,95,75,57,95,75,16,81,84,14,37,38,95,34,2,96,45,24,27,25,17,53,66,83,44,86,22,45,77,20,1,23,15,28,32,63,4,49,44,40,15,33,79,10,19,33,58,65,9,37,90,26,90,8,62,86,95,36,84,72,57,37,47,72,17,80,35,73,81,32,14,96,17,45,58,37,78,68,54,88,58,44,66,48,52,28,87,99,65,23,72,22,60,71,94,77,51,82,51,32,66,17,80,35,62,38,24,92,7,78,32,65,22,99,65,27,27,4,78,92,27,2,14,87,74,61,17,25,95,20,10,13,37,90,0,51,29,25,43,88,55,76,5,30,27,22,57,54,27,87,47,6,90,13,46,64,26,63,41,73,35,51,38,72,94,39,75,23,64,18,63,19,46,20,49,25,42,58,80,21,46,79,80,88,44,26,52,23,41,45,96,76,97,35,0,91,26,75,66,90,45,81,61,44,1,63,69,95,73,49,69,71,80,49,59,25,27,63,48,68,9,96,96,58,31,96,1,9,71,19,51,68,0,13,12,53,28,82,48,53,83,69,77,16,70,88,41,97,52,41,65,13,37,13,23,21,9,76,30,32,95,82,1,47,47,65,0,27,99,0,32,83,22,9,99,92,98,92,90,50,33,7,15,22,21,90,95,30,66,26,15,61,60,16,8,59,33,60,86,33,12,18,68,34,28,19,27,78,11,17,80,96,76,95,70,97,85,66,80,3,44,95,64,4,63,24,15,96,36,1,29,48,71,49,83,51,68,62,29,31,31,9,79,7,56,50,57,93,68,37,96,12,32,12,68,47,88,83,43,24,36,25,25,59,26,8,63,95,22,92,78,53,54,58,12,62,60,69,8,80,6,4,44,90,69,64,37,57,99,33,34,35,10,59,46,36,19,9,83,41,54,62,46,60,72,58,22,32,28,30,64,34,87,8,77,8,72,66,65,71,99,51,58,61,10,56,98,29,66,81,70,20,95,16,80,67,27,54,51,55,37,15,41,76,75,70,84,47,37,1,70,88,53,80,50,63,37,0,45,55,33,15,75,29,84,7,96,11,61,0,18,50,15,11,26,91,82,10,90,19,64,13,7,69,93,9,32,82,9,77,37,43,45,12,72,81,71,20,44,85,20,62,35,88,25,14,31,7,76,73,78,40,86,86,9,80,95,94,62,5,23,0,0,68,64,72,1,88,44,45,73,17,59,60,57,85,74,88,44,51,61,23,43,0,9,53,80,56,47,94,13,22,46,65,91,11,37,92,51,34,90,24,51,49,84,60,86,11,48,31,62,61,54,5,61,15,10,93,23,9,88,37,32,86,2,75,49,92,19,0,78,9,24,81,11,61,41,97,24,41,28,38,54,82,43,68,97,6,61,21,15};
        final ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.bruteForce(arr));
        System.out.println(containerWithMostWater.maxArea(arr));
    }


    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(area, maxArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    /**
     * 暴力破解法
     * @param height
     * @return
     */
    public int bruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}
