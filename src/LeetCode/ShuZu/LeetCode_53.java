package LeetCode.ShuZu;

import java.util.Scanner;

/*
该题中，子数组是数组中的一个连续部分。求最大和的连续子数组（子数组最少包含一个元素）
 */

// 53. 最大子数组和
// https://leetcode.cn/problems/maximum-subarray/description/
public class LeetCode_53 {

    public static void main(String[] args) {
        // ACM 模式
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++){
//            arr[i] = scanner.nextInt();
//        }
//        System.out.println(maxSubArray(arr));

        // 测试
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        int[] n2 = {1};
        System.out.println(maxSubArray(n2));

        int[] n3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(n3));

    }


    /*
    DP思想，定义 dp[n] 以nums[n]为结尾的连续子数组和的最大值，这是最关键的一步，因为要求是连续子数组，不这样定义不方便得出转移方程
    转移方程：dp[n] = dp[n - 1] + nums[n] 或者 nums[n]
    因为要以nums[n]结尾，所以如果dp[n - 1] > 0，则dp[n] = dp[n - 1] + nums[n]
    如果dp[n - 1] < 0，则dp[n] = nums[n]，不用加上dp[n - 1]
    由于每次计算转移方程时，只需要知道 dp[n - 1]，所以完全可以只用一个变量sum来存储，只不过我们初始化要为1
     */
    // 2
    public static int maxSubArray(int[] nums) {
        int sum = 0, res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = Math.max(sum, 0) + nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    // 1
//    public static int maxSubArray(int[] nums) {
//        int sum = 0, res = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++){
//            sum = Math.max(sum, 0) + nums[i];
//            res = Math.max(res, sum);
//        }
//        return res;
//    }
}
