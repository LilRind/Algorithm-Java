package Lianxi.DP;

import java.util.*;

// #P1521. 2023.09.02-TT-研发-第二题-特别数组
// 没看明白 dp + 倍增
/*
特别数组，i在[1,n]，a_i在[1,m]
当i在[1,n]，a_i是i的倍数
a_1+a_2+...+a_n 是 n的倍数
 */
public class TaoTian_23_0902_2 {
    static final int mod = (int)1E9 + 7;  // 定义模数
    static final int N = (int)1E3 + 10;  // 定义数组大小
    static int[][] f = new int[N][N];  // 定义f[i][j]为前i个数的总和结果对n取模的结果为j的方案数
    static int n, m;  // 输入的两个整数

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();  // 输入第一个整数 n，元素个数
        m = scanner.nextInt();  // 输入第二个整数 m，元素最大值
        f[0][0] = 1;  // 初始状态，表示没有任何元素时的值为1
        for (int i = 1; i <= n; i++) {  // 遍历 1 到 n，表示当前正在考虑的元素的值
            for (int k = 0; k < n; k++) {  // 第二层循环，遍历 0 到 n-1，表示前 i-1 个数字的总和对 n 取模的结果
                for (int j = i; j <= m; j += i) {  // i，2*i，...k*i枚举
                    int cur = (j + k) % n;  // 计算当前位置的索引，cur表示前i个数字的总和对n取模
                    f[i][cur] = (f[i][cur] + f[i - 1][k]) % mod;  // 更新状态转移值，累加前一个状态的值
                }
            }
        }
        System.out.println(f[n][0]);  // 输出结果
    }
}
