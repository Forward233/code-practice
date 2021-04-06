package com.leetcode.dp;

/**
 * @author: yhl
 * @DateTime: 2021/4/2 14:28
 * @Description:
 */
public class Redraiment {

    public static void main(String[] args) {

    }

    //        2 5 1 5 4 5
    //    样例输出
    //3
    //
    //    提示
    //    Example: 
    //    6个点的高度各为 2 5 1 5 4 5 
    //    如从第1格开始走,最多为3步, 2 4 5 
    //    从第2格开始走,最多只有1步,5 
    //    而从第3格开始走最多有3步,1 4 5 
    //    从第5格开始走最多有2步,4 5

    public int redraiment(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}

