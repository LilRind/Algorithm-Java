package Fuxi.DP;

import java.util.Scanner;

// 打家劫舍
// https://leetcode.cn/problems/house-robber/description/
public class LeetCode_198 {
    static final int N = 110;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 数组长度
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }

        f[1] = nums[0];
        for(int i = 2; i <= n; i++){
            f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]);
        }
        System.out.println(f[n]);
    }
}
/*
4
1 2 3 1

5
2 7 9 3 1
*/
