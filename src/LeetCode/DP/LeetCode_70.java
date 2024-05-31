package LeetCode.DP;

/*
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 */

// K神：O(1)空间复杂度
// https://leetcode.cn/problems/climbing-stairs/solutions/2361764/70-pa-lou-ti-dong-tai-gui-hua-qing-xi-tu-ruwa/?envType=study-plan-v2&envId=top-100-liked

// 灵神：一步一步解答最优解
// https://leetcode.cn/problems/climbing-stairs/solutions/2560716/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-7zm1/?envType=study-plan-v2&envId=top-100-liked

// 大鹏：斐波那契数列公式，O(logN)时间复杂度
// https://leetcode.cn/problems/climbing-stairs/solutions/9983/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 70. 爬楼梯
public class LeetCode_70 {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(climbStairs(a));

        int c = 5;
        System.out.println(climbStairs(c));

    }

    // 第一次解出
    // dp[i]代表到达第i阶有dp[i]种方法。则dp[i] = dp[i-1] + dp[i-2](i >= 2)
    // dp[1] = 1, dp[2] = 2
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n <= 1) {
            return dp[n]; // 如果楼梯数小于等于1，直接返回对应的爬楼梯方式数量
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 灵神：掌握。
    /*
    public int climbStairs(int n) {
        int f0 = 1, f1 = 1; // 前一个状态，后一个状态
        for (int i = 2; i <= n; i++) { // 第一个台阶和第二个台阶结果都是1
            int newF = f1 + f0; // 新状态
            f0 = f1; // 更新前一个状态
            f1 = newF; // 更新后一个状态
        }
        return f1; // 返回新状态
    }
     */

    // 大鹏：斐波那契数列公式
    /*
        public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }
     */

    // 之前写的
    /*
    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // 创建一个数组用于存放爬楼梯的方式数量，长度为 n+1
        dp[0] = 1; // 初始情况：只有一级楼梯时，只有一种爬法
        dp[1] = 1; // 初始情况：有两级楼梯时，有两种爬法

        if (n <= 1) {
            return dp[n]; // 如果楼梯数小于等于1，直接返回对应的爬楼梯方式数量
        }

        for (int i = 2; i <= n; i++) { // 从第三级楼梯开始计算爬楼梯的方式数量
            dp[i] = dp[i - 1] + dp[i - 2]; // 当前楼梯的爬法数量等于前两级楼梯的爬法数量之和
        }

        return dp[n]; // 返回最后一级楼梯的爬法数量，即总的爬楼梯方式数量
    }
     */
}
