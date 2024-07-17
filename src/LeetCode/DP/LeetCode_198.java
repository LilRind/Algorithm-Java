package LeetCode.DP;

import java.util.Scanner;

/*
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

// 灵神：掌握，常规dp
// https://leetcode.cn/problems/house-robber/solutions/2102725/ru-he-xiang-chu-zhuang-tai-ding-yi-he-zh-1wt1/?envType=study-plan-v2&envId=top-100-liked

// K神：掌握。空复O（1）
// https://leetcode.cn/problems/house-robber/solutions/28242/da-jia-jie-she-dong-tai-gui-hua-jie-gou-hua-si-lu-/?envType=study-plan-v2&envId=top-100-liked

// 重点关注
// 打家劫舍
// https://leetcode.cn/problems/house-robber/description/
public class LeetCode_198 {
    // dp定义为：第i位前的偷取到的最大金额

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组长度
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
         */
        int[] a = new int[]{1, 2, 3, 1};

        int[] b = new int[]{2, 7, 9, 3, 1};

        System.out.println(rob(a));
        System.out.println(rob(b));

    }

    // 第二次解出，但仍需要注意dp[a]与nums[b]的对应关系
//    public static int rob(int[] nums) {
//        /*
//        如果dp[i]对应nums[i]，那么必然边界问题(i>=2)。
//        所以应该让dp[i+2]对应nums[i]，那么i>=0。
//        然而i最大为n-1，那么返回值为dp[n+1]，所以构造int[] dp = new int[n+2]，n为数组长度
//        */
//        int n = nums.length;
//        // dp[n]代表第n个所能获取的最大金额，从1开始计数
//        int[] dp = new int[n + 1];
//        dp[1] = nums[0]; // 第1个位置的最大金额是nums[0]
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//        return dp[n]; // 返回第n个位置获取的最大金额。
//    }

    // 第二次解出：尝试用空间复杂度O(1)来解决，需要一定熟练度
    public static int rob(int[] nums) {
        int pre1 = 0, pre2 = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = Math.max(nums[i] + pre1, pre2);
            pre1 = pre2;
            pre2 = cur;
        }
        return pre2;
    }

    // 第一次未解出。注意把握dp[]与nums[]的位数关系
    /*
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
    */


    // 灵神：掌握。常规dp
    /*
    public int rob(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]); // f[i+2]对应nums[i]
        }
        return f[n + 1]; // nums[n-1]是末尾元素，所以返回对应的f[n+1]
    }
     */

    // K神/灵神：掌握。空复O（1）
    /*
    // 灵神
    public int rob(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int x : nums) {
            int newF = Math.max(f1, f0 + x);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    // K神
    public int rob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
     */


    // 之前写的
    /*
    static final int N = 110;
    static int[] f = new int[N];

    public int rob(int[] nums) {
        int n = nums.length;
        f[1] = nums[0]; // f[]从下标1开始
        for (int i = 2; i<=n; i++){
            f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]); // nums[i-1]是第i个值
        }
        System.out.println(f[n]);
    }
     */


}
