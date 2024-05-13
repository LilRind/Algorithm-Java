package Fuxi.DP;

import java.util.Scanner;

// 不是很熟练
// 科大讯飞-2022.10.10-闯关
// https://codefun2000.com/p/P1037
public class kedaxunfei_22_chuangguan {
    static final int N = 1010;
    static int n, m, f[][] = new int[N][N]; // f[i][j]代表"s"字符串前i个字符和"t"字符串前j个字符的最大连续公共子串

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        n = s.length();
        m = t.length();

        int res = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + 1;
                }
                res = Math.max(res, f[i][j]);
            }
        }
        System.out.println(res*2);
    }
}