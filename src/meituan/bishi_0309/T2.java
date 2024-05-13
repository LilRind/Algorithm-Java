package meituan.bishi_0309;

import java.util.Scanner;

public class T2 {
    static final int maxn = 100010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[maxn];
        long cnt = 0;
        long sum = 0;
        for (int i = 1; i <= n; ++i) {
            a[i] = scanner.nextInt();
            if (a[i] == 0) {
                cnt++;
            } else {
                sum += a[i];
            }
        }
        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println((sum + l * cnt) + " " + (sum + r * cnt));
        }
    }
}

