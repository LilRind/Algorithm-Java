package Fuxi.DP;

import java.util.Scanner;

// 不是很熟练
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
            for (int j = 1; j <= t.length(); j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + (s.charAt(i-1) == t.charAt(j-1) ? 1 : 0));
            }
        }
        System.out.println(f[s.length()][t.length()]);
    }
}
