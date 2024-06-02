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

// 涉及背包问题（灵神的讲解 0-1、完全）
// https://www.bilibili.com/video/BV16Y411v7Y6/

// 重点关注
// 416. 分割等和子集
public class LeetCode_416 {
    public static void main(String[] args) {

    }

    // 文末有详细分析
    // 灵神：掌握。f[i] 表示是否可以找到一个子集，使得其元素之和等于 i。
    // 在计算 f[i+1] 时，只会用到 f[i]，不会用到比 i 更早的状态。
    public boolean canPartition(int[] nums) {
        int s = 0; // 数组总和
        for (int x : nums) {
            s += x;
        }
        if (s % 2 != 0) { // 总和不是偶数，即不能对半分
            return false;
        }
        s /= 2; // 注意这里把 总和s 减半了
        boolean[] f = new boolean[s + 1]; // f[i] 表示是否可以找到一个子集，使得其元素之和等于 i。
        f[0] = true; // 不选任何元素，所以为true
        int s2 = 0;
        for (int x : nums) { // 对于每一个元素
            // 更新 s2，表示当前考虑过的元素的最大和，但不超过目标和 s
            s2 = Math.min(s2 + x, s); // 前缀和
            // 从 s2 开始，向下遍历到 x
            // 这是因为我们要确保在考虑当前元素 x 时，计算出的新的子集和不超过 s
            // 同时避免重复计算更小的和
            for (int j = s2; j >= x; j--) {
                // 更新 dp 数组：如果存在一个子集和为 j - x，
                // 那么在加上 x 之后，就会有一个子集和为 j
                // j在[x,s2+x]之中,f[x]和f[s2+x]必定为true，
                // 而j-x在[0,s2]中，f[0,s2]的值与 元素x 无关，所以f[j-x]为true，则f[j]必定成立
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

// 详细分析
/*
4. 遍历数组 nums 并更新 f
java
复制代码
int s2 = 0;
for (int x : nums) {
    s2 = Math.min(s2 + x, s);
    for (int j = s2; j >= x; j--) {
        f[j] = f[j] || f[j - x];
    }
}
逐步分析每一步：

第一次迭代 (x = 1)
s2 = Math.min(s2 + x, s) = Math.min(0 + 1, 11) = 1
内层循环：

for (int j = 1; j >= 1; j--) {
    f[j] = f[j] || f[j - 1]; // f[1] = f[1] || f[0] = false || true = true
}
f 数组更新为 [true, true, false, false, false, false, false, false, false, false, false, false]
第二次迭代 (x = 5)
s2 = Math.min(s2 + x, s) = Math.min(1 + 5, 11) = 6
内层循环：

for (int j = 6; j >= 5; j--) {
    f[6] = f[6] || f[6 - 5]; // f[6] = f[6] || f[1] = false || true = true
    f[5] = f[5] || f[5 - 5]; // f[5] = f[5] || f[0] = false || true = true
}
f 数组更新为 [true, true, false, false, false, true, true, false, false, false, false, false]
第三次迭代 (x = 11)
s2 = Math.min(s2 + x, s) = Math.min(6 + 11, 11) = 11
内层循环：

for (int j = 11; j >= 11; j--) {
    f[11] = f[11] || f[11 - 11]; // f[11] = f[11] || f[0] = false || true = true
}
f 数组更新为 [true, true, false, false, false, true, true, false, false, false, false, true]
第四次迭代 (x = 5)
s2 = Math.min(s2 + x, s) = Math.min(11 + 5, 11) = 11
内层循环：

for (int j = 11; j >= 5; j--) {
    f[11] = f[11] || f[11 - 5]; // f[11] = true || f[6] = true || true = true
    f[10] = f[10] || f[10 - 5]; // f[10] = false || f[5] = false || true = true
    f[9] = f[9] || f[9 - 5]; // f[9] = false || f[4] = false
    f[8] = f[8] || f[8 - 5]; // f[8] = false || f[3] = false
    f[7] = f[7] || f[7 - 5]; // f[7] = false || f[2] = false
    f[6] = f[6] || f[6 - 5]; // f[6] = true || f[1] = true
    f[5] = f[5] || f[5 - 5]; // f[5] = true || f[0] = true
}
f 数组更新为 [true, true, false, false, false, true, true, false, false, false, true, true]
5. 返回结果

return f[s]; // f[11] = true
因为 f[11] 是 true，表示存在一个子集，其和为 11，因此返回 true。
最终，代码确认 nums 数组可以分割成两个和相等的子集 [1, 5, 5] 和 [11]。
 */
