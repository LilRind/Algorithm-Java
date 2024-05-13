package Fuxi.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// LeetCode 300. 最长递增子序列
// https://leetcode.cn/problems/longest-increasing-subsequence/description/

// 核心思想是遍历元素，如果后一个元素大于序列末尾元素，则加入末尾，如果后一个元素小于序列末尾元素，则覆盖序列中对应的位置
public class LeetCode_300 {
    static final int N = 2510;
    static int n, nums[] = new int[N], f[] = new int[N]; // f[i]代表以第i个元素结尾的最长递增子序列的长度

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        int res = 1;
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    res = Math.max(res, f[i]);
                }
            }
        }

        System.out.println(f[n]);  // 输出最长递增子序列的长度
    }



}