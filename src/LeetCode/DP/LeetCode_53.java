package LeetCode.DP;

import java.util.Scanner;

// 53. 最大子数组和
// https://leetcode.cn/problems/maximum-subarray/description/
public class LeetCode_53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            sum = Math.max(sum, 0) + arr[i];
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}
