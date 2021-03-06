package com.leetcode.greedy;

import java.util.Arrays;

/**
 * @author: yhl
 * @DateTime: 2021/2/24 14:49
 * @Description: 硬币兑换
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 此层循环，当金额递增时，所需要最小的coin
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {    // [1,2,5]
                if (coin <= i) {
                    // dp[i]为初始化的amount + 1
                    // 明显 ，它的意义是：利用11来凑出15，付出的代价等于f(4)加上自己这一张钞票。现在我们暂时不管f(4)怎么求出来。
                    // 依次类推m，马上可以知道：如果我们用5来凑出15，cost就是f(10) + 1 = 2 + 1 = 3 。　
                    //　那么，现在w=15的时候，我们该取那种钞票呢？当然是各种方案中，cost值最低的那一个
                    //- 取11：　cost=f(4)+1=4+1=5　
                    //- 取5： 　 cost = f(10) + 1 = 2 + 1 = 3
                    //- 取1： 　cost = f(14) + 1 = 4 + 1 = 5
                    //显而易见，cost值最低的是取5的方案。我们通过上面三个式子，做出了正确的决策!
                    //这给了我们一个至关重要的启示—— 只与 相关；更确切地说： f(n) 只与 f(n-1),f(n-5),f(n-11) 相关；更确切地说：
                    //f(n)=min{f(n-1),f(n-5),f(n-11)}+1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
