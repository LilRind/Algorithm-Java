package LeetCode.DP;

import java.util.Scanner;

// 152. 乘积最大子数组
/*

输入:
4
2 3 -2 4
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

输入:
3
-2 0 -1
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

-3,0,1,-2
输出: 1

 */

// 重点关注
// 152. 乘积最大子数组
public class LeetCode_152 {

    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4};
        System.out.println(maxProduct(a));

        int[] b = {-2, 0, -1};
        System.out.println(maxProduct(b));

        int[] c = {-3,0,1,-2};
        System.out.println(maxProduct(c));

        // acm模式
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
         */
    }

    // 2
    /*
    核心思想是：用maxProd、minProd分别存当前子数组的最大、最小乘积，因为最小的负数乘以负数可能变为最大乘积
    转换方程，maxProd = Math.max(nums[i], maxProd * nums[i])。minProd = Math.min(nums[i], minProd * nums[i])
     */
    public static int maxProduct(int[] nums) {
        // 如果数组为空，返回0
        if (nums.length == 0) return 0;

        // 初始化三个变量：
        // maxProd - 当前子数组的最大乘积
        // minProd - 当前子数组的最小乘积，因为负数乘以负数可以变成正数
        // res - 结果，存储最大乘积
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = nums[0];

        // 从数组的第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 负数乘以 minProd（最小乘积）可能会变成最大的正数
            // 如果当前元素为负数，交换 maxProd 和 minProd，因为之后要更新 maxProd、minProd
            // 由于 nums[i] < 0， 那么 maxProd 和 minProd 需要交换，才能保证maxProd，minProd正确更新
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // 计算当前元素作为新子数组起点的最大乘积和最小乘积
            maxProd = Math.max(nums[i], maxProd * nums[i]); // 更新maxProd，比较当前元素nums[i] 与 maxProd * nums[i]的大小
            minProd = Math.min(nums[i], minProd * nums[i]); // 更新minProd，比较当前元素nums[i] 与 minProd * nums[i]的大小

            // 更新结果 res 为当前所有子数组乘积中的最大值
            res = Math.max(res, maxProd);
        }

        // 返回结果 res
        return res;
    }





    // 1，存在一点小问题
/*
    // 这个算法无法解决，输入 = [0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0]的情况
    // 其它情况下，这是最简单且运行时间最小的解法之一。
    // 由于负数的出现，会导致之前的最大变成最小，导致后续可能出现的最大变成负数，所以反向再遍历一次求最大。

    // 简化版
    public static int maxProduct(int[] nums) {
        int res = nums[0]; // 确保返回的结果至少是nums中的单个元素
        int ans = 1; // 保留每个连续非空连续子数组的乘积
        for (int i = 0; i < nums.length; i++) { // 从左到右先乘
            ans *= nums[i]; // 先乘
            res = Math.max(res, ans);
            if(nums[i] == 0) ans = 1; // 如果遇到元素0，则重新置为1
        }
        ans = 1; // 重新置为1
        for (int i = nums.length-1; i >= 0; i--) { // 从右到左先乘
            ans *= nums[i];
            res = Math.max(res, ans);
            if(nums[i] == 0) ans = 1; // 如果遇到元素0，则重新置为1
        }
        return res;
    }

    // 未简化版
    public int maxProduct(int[] nums) {
        // 初始化乘积为1，并获取数组长度
        int product = 1, n = nums.length;

        // 初始化最大值为数组第一个元素
        int max = nums[0];

        // 从左向右遍历数组
        for(int i = 0; i < n; i++) {
            // 计算当前乘积，并更新最大值
            product *= nums[i];
            max = Math.max(max, product);

            // 如果当前元素为0，重置乘积为1（因为乘以0会使乘积归零）
            if(nums[i] == 0) {
                product = 1;
            }
        }

        // 重置乘积为1，用于从右向左遍历数组
        product = 1;

        // 从右向左遍历数组
        for(int i = n - 1; i >= 0; i--) {
            // 计算当前乘积，并更新最大值
            product *= nums[i];
            max = Math.max(max, product);

            // 如果当前元素为0，重置乘积为1（因为乘以0会使乘积归零）
            if(nums[i] == 0) {
                product = 1;
            }
        }

        // 返回最大乘积
        return max;
    }
*/

}

