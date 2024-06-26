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

    // 再写，第一次写更改后
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

    // 第一次未解出，存在一点小问题
    /*
    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) ans = 1;
            ans *= nums[i];
            res = Math.max(res, ans);
        }
        ans = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i] == 0) ans = 1;
            ans *= nums[i];
            res = Math.max(res, ans);
        }
        return res;
    }
     */

    // 这是之前做的
    /*
    public static int maxProduct(int[] nums) {
        // 获取输入数组的长度
        int length = nums.length;

        // 初始化数组以存储以第i个索引结尾的最大和最小乘积
        int[] maxF = new int[length];
        int[] minF = new int[length];

        // 将输入数组 nums 复制到 maxF 和 minF
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);

        // 计算以每个索引结尾的最大和最小乘积
        for (int i = 1; i < length; ++i) {
            // 更新 maxF[i]，nums[i]>0，选取nums * maxF前一位的最大值；nums<0，选取nums * maxF前一位的最小值，与nums[i]比较
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));

            // 更新 minF[i]，nums[i]>0，选取nums * maxF前一位的最小值；nums<0，选取nums * maxF前一位的最大值，与nums[i]比较
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }

        // 在所有子数组中找到最大乘积
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }

        // 返回最大乘积
        return ans;
    }
     */

}

// 这是最简单的做法。由于负数的出现，会导致之前的最大变成最小，导致后续可能出现的最大变成负数，所以反向再遍历一次求最大。
/*

class Solution {
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
}

*/
