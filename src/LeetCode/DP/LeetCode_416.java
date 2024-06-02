package LeetCode.DP;

import java.util.Arrays;

/*
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */

// 灵神：dp、记忆化搜索、递推
// https://leetcode.cn/problems/partition-equal-subset-sum/solutions/2785266/0-1-bei-bao-cong-ji-yi-hua-sou-suo-dao-d-ev76/?envType=study-plan-v2&envId=top-100-liked

// 涉及0-1背包问题

// 重点关注
// 416. 分割等和子集
public class LeetCode_416 {
    public static void main(String[] args) {

    }


    // 在计算 f[i+1] 时，只会用到 f[i]，不会用到比 i 更早的状态。
    public boolean canPartition(int[] nums) {
        int s = 0; // 数组总和
        for (int x : nums) {
            s += x;
        }
        if (s % 2 != 0) { // 总和不是偶数，即不能对半分
            return false;
        }
        s /= 2; // 注意这里把 s 减半了
        boolean[] f = new boolean[s + 1];
        f[0] = true;
        int s2 = 0;
        for (int x : nums) {
            s2 = Math.min(s2 + x, s);
            for (int j = s2; j >= x; j--) {
                f[j] = f[j] || f[j - x];
            }
        }
        return f[s];
    }


    // f[i][j] 的定义和 dfs(i,j) 的定义是一样的，都表示能否从 nums[0] 到 nums[i] 中选出一个和为 j 的子序列。
    // dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
    /*
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if (s % 2 != 0) {
            return false;
        }
        s /= 2; // 注意这里把 s 减半了
        int n = nums.length;
        boolean[][] f = new boolean[n + 1][s + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <= s; j++) {
                f[i + 1][j] = j >= x && f[i][j - x] || f[i][j];
            }
        }
        return f[n][s];
    }

     */

    // 第一次未解出。思路：排序 + 前缀和。思路有问题
    /*
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int tempSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            tempSum += nums[i];
            if(tempSum == sum - tempSum){
                return true;
            }
        }
        return false;

        // 这个思路也是错的
        int n = nums.length;
        int sum = 0; // 数组总和
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += nums[i];
            int l = i+1;
            while (l < n){
                int mid = l + (n - l)/2;
                if(tempSum + nums[mid] == sum/2){
                    return true;
                }else if(tempSum + nums[mid] < sum/2){

                }
            }

        }

    }
    */
}
