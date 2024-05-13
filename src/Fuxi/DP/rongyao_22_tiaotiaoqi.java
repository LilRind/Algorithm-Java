package Fuxi.DP;

import java.util.Scanner;

// 比较熟练
// 荣耀-2022.10.13-跳跳棋
// https://codefun2000.com/p/P1035
public class rongyao_22_tiaotiaoqi {
    static final int N = 100010;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        f[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]);
        }
        System.out.println(f[n]);
    }
}
