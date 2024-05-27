package LeetCode.DP;

import java.util.Scanner;

// 1143. 最长公共子序列
// https://leetcode.cn/problems/longest-common-subsequence/description/
public class LeetCode_1143 {
    static final int N = 1010;
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]); // j先右移一位，还是i右移一位公共子序列长
                // i、j同时移动一位与j先右移一位、i右移一位中较大者比较，谁更长
                f[i][j] = Math.max(f[i][j], f[i-1][j-1] + (s.charAt(i-1) == t.charAt(j-1) ? 1 : 0));
            }
        }
        System.out.println(f[s.length()][t.length()]);
    }
}
