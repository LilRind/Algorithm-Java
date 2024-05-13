package Lianxi.DP;

import java.util.Scanner;

// 科大讯飞-2022.10.10-闯关
// https://codefun2000.com/p/P1037
public class kedaxunfei_22_chuangguan {
    static final int N = 1010;
    static int n, m, f[][] = new int[N][N];


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        m = s.length();
        n = t.length();
        int res = 0;
        s = " " + s;
        t = " " + t;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                res = Math.max(f[i][j], res);
            }
        }
        System.out.println(res * 2);
    }
}