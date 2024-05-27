package LeetCode.DP;

import java.util.Scanner;

// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
// f[i][j]是以 nums1[i-1] 和 nums2[j-1] 结尾的最长重复子数组的长度
// nums1[i] 不等于 nums2[i]：f[i][j] = 0
// nums1[i] 等于 nums2[i]：f[i][j] = f[i-1][j-1] + 1
public class LeetCode_718 {
    static final int N = 1010;
    static int n, m, nums1[] = new int[N], nums2[] = new int[N], f[][] = new int[N][N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
        }
        for(int i = 0; i < m; i++) {
            nums2[i] = scanner.nextInt();
        }

        int res = 0;
        int[][] f = new int[n+1][m+1]; // Longest common subarray ending with nums1[i] and nums2[j]
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(nums1[i-1] == nums2[j-1]) f[i][j] = f[i-1][j-1] + 1;
                res = Math.max(res, f[i][j]);
            }
        }
        System.out.println(res);
    }
}
/*

5 5
1 2 3 2 1
3 2 1 4 7

3

 */