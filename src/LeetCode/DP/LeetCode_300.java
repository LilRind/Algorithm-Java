package LeetCode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

输入：nums = [0,1,0,3,2,3]
输出：4

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */

// LeetCode 300. 最长递增子序列
// https://leetcode.cn/problems/longest-increasing-subsequence/description/

// 核心思想是遍历元素，如果后一个元素大于序列末尾元素，则加入末尾，如果后一个元素小于序列末尾元素，则覆盖序列中对应的位置
public class LeetCode_300 {
    static final int N = 2510;
    static int n, nums[] = new int[N], f[] = new int[N];

    public static void main(String[] args) {
        int[] num1 = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(num1));

        // 之前的写法
        /*
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        int result = lengthOfLIS(nums, n);
        System.out.println(result);  // 输出最长递增子序列的长度
        */
    }

    // 第一次未解出。
    public static int lengthOfLIS(int[] nums) {
        // res代表最长递增子序列的长度。因为逻辑判断是当nums[j] < nums[i]才进行dp[]更新
        int len = nums.length, res = 1;
        // dp[i] 代表以 nums[i] 结尾的最长子序列长度。注意这里不是前i位的最长递增子序列长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++){
                if(nums[j] < nums[i]){ // 当nums[j] < nums[i]才进行dp[]更新
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }

    // K神：纯动态规划。O(N^2)，O(N)
    /*
    // Dynamic programming.
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
     */

    // K神：动态规划 + 二分查找。O(NlogN)，O(N)
    // 最快的解法之一
    /*
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

     */


    // 之前写的，计算最长递增子序列的长度
    /*
    public static int lengthOfLIS(int[] nums, int n) {
        List<Integer> v = new ArrayList<>();  // 创建一个ArrayList用于存储递增子序列的元素

        for (int i = 0; i < n; i++) {  // 遍历数组
            int x = nums[i];  // 获取当前位置的元素
            if (v.isEmpty() || v.get(v.size() - 1) < x) {  // 如果v为空或者当前元素大于递增子序列的最后一个元素
                v.add(x);  // 将当前元素添加到递增子序列中

            } else {  // 否则
                int pos = binarySearch(v, x);  // 通过二分查找找到当前元素在递增子序列中的位置
                v.set(pos, x);  // 将递增子序列中对应位置的元素更新为当前元素
            }
            System.out.println("v：" + v);
        }


        return v.size();  // 返回递增子序列的长度
    }

    // 二分查找，找到插入位置
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();  // 初始化二分查找的左右边界
        while (left < right) {  // 当左边界小于右边界时
            int mid = left + (right - left) / 2;  // 计算中间位置
            if (list.get(mid) < target) {  // 如果中间位置的元素小于目标元素
                left = mid + 1;  // 更新左边界为中间位置加1
            } else {  // 否则
                right = mid;  // 更新右边界为中间位置
            }
        }
        return left;  // 返回目标元素应该插入的位置
    }
    */

}
/*
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 1;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    res = Math.max(res, f[i]);
                }
            }
        }
        return res;
    }
}

*/

