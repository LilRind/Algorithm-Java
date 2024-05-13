package Lianxi.DP;

import java.util.Arrays;
import java.util.Scanner;

// 携程-2023.3.7-稳定数组
// https://codefun2000.com/p/P1066
public class xiecheng_23_wendingshuzu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        int[] f = new int[n]; // f[i]代表离第i个数字中的最近的稳定连续子数组的长度
        Arrays.fill(f, 1); // 全部初始化为 1

        int res = 1;
        for(int i = 0; i < n; i++) {
            // 第i个与第i-1个相邻元素绝对值之差不超过1，则f[i] 为前一个 f[i-1]+1
            if(i > 0 && Math.abs(arr[i] - arr[i-1]) <= 1) f[i] = f[i-1] + 1;
            res = Math.max(res, f[i]);
        }
        System.out.println(res);

    }

}


/*

import java.util.*;

public class Main {
    static final int N = 100010;
    static int n, a[] = new int[N], f[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = 1;
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) <= 1) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = 1;
            }
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }
}

 */