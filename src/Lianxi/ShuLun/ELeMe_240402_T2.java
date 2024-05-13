package Lianxi.ShuLun;


import java.util.Scanner;

// 算法考点：数论 最大公约数
public class ELeMe_240402_T2 {
    static final int N = 100010;
    static int[] a = new int[N];
    static int n;
    static long k;

    // 辗转相除法求最大公约数
    static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextLong();
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            int c = a[1];
            for (int i = 2; i <= n; i++) {
                c = gcd(c, a[i]); // 求所有绳子的最大公约数
            }
            long cnt = 0;  // 需要的操作次数
            for (int i = 1; i <= n; i++) {
                cnt += (a[i] / c) - 1; // 求累加的切割次数
            }
            if (cnt > k) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
