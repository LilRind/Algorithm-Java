package Lianxi.HuaDongChuangKou;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://leetcode.cn/problems/subarray-product-less-than-k/
/*
target, nums.length

2 11
1 1 1 0 0 0 1 1 1 1 0
输出：
6
解释：[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。

3 19
0 0 1 1 0 0 1 1 1 0 1 1 0 0 0 1 1 1 1
输出：
10
解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。

 */
// https://leetcode.cn/problems/minimum-size-subarray-sum/solutions/305704/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
public class LeetCode_1004 {

    public static int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, cnt0 = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 最大翻转次数（0变1）
        int n = sc.nextInt(); // 数组长度
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(longestOnes(nums, k));
    }
}

/*

// 官方：
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

// 灵神
// 统计窗口内 0 的个数 cnt0，则问题转换成在 cnt0≤k的前提下，窗口大小的最大值。
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, left = 0, cnt0 = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

// 我的
    public static int longestOnes(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int start = 0;
        int same = 0;
        for (int r = 1; r < n; r++) {
            if(nums[r] == 1) continue;
            else if(k>0 && nums[r+k] == 1) r = r+k;

        }

        for (int r = 1; r < n; r++) {
            if(nums[r] == 1 && nums[r-1] == 0){
                same = r;
            }else if(k > 0 && nums[r+k] == 1){
                same = r;
                k = 0;
                res = Math.max(res, end - same)
                continue;
            }

        }

        return res;
    }

 */