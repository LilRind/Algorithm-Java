package LeetCode.DP;

import java.util.Arrays;

/*
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

输入：coins = [2], amount = 3
输出：-1

输入：coins = [1], amount = 0
输出：0
 */

// sugar：dp、记忆化搜索、递归(超时不推荐)
// https://leetcode.cn/problems/coin-change/solutions/137661/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 零钱兑换
public class LeetCode_322 {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins, amount));
    }


    // Sugar：与官方类似
    public static int coinChange(int[] coins, int amount) {
        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount+1];
        // 给dp赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // 标记。 amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(dp,amount+1);
        dp[0] = 0; // 金额为0，dp也为0
        for(int i = 1; i <= amount;i++){ // 从1到总金额
            for(int j = 0; j < coins.length;j++){ // 遍历每种面额
                if(i - coins[j] >= 0){ // 如果当前总金额 >= 当前面额
                    // dp[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 dp[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是dp[i]
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[amount] == (amount+1) ? -1 : dp[amount]; // 如果dp[] == 标记则为 -1 否则不变
    }

    // 这个写法用了语法糖，比官方答案快1ms，逻辑与官方基本一致
    /*
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] =0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if(coin<=i){
                    dp[i] =Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
     */


    // 官方：掌握，O(Sn),O(S)，S 是金额，n 是面额数
    /*
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
     */

    // 第一次未解出，存在逻辑问题。
    /*
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // dp[i]凑成总金额所需的最少的硬币个数
        // 对于每个总金额
        for (int i = 1; i <= amount; i++) {
            // 从coins[0]开始，求凑成当前金额所需的最少的硬币个数
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++) {
                temp = Math.min(temp, com);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 :temp + 1;
    }
     */

}
