package Fuxi.DP;

import java.util.Arrays;
import java.util.Scanner;

// 携程-2023.3.7-稳定数组
// https://codefun2000.com/p/P1066
// 稳定数组：因为相邻元素绝对值之差不超过1


// 24_04_23 14:08 - 14:36 - 14:42
// 和官方答案稍微有些出入，注意dp数组的定义
public class xiecheng_23_wendingshuzu {
    static int N = 100010;

    static int[] dp = new int[N+1]; // dp[i]代表离第i个数字中的最近的稳定连续子数组的长度
    // 6
    // 2 3 5 4 5 6
    // dp[1, n]输出：
    // 1 2 1 2 3 4

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 2; i <= n; i++){
            if(Math.abs(a[i-1]-a[i-2]) <= 1) {
                dp[i] = dp[i-1] + 1;
            }
            else dp[i] = 1;
            max = Math.max(max, dp[i]);
//            System.out.print(dp[i] + " ");
        }
//        System.out.println();
        System.out.println(max);
    }
}








/*

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
 */











//public class xiecheng_23_wendingshuzu {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++){
//            arr[i] = scanner.nextInt();
//        }
//
//        int[] dp = new int[n+1];
//        Arrays.fill(dp, 1);
//        int res = 1;
//        for(int i = 0; i < n; i++){
//            if(i > 0 && Math.abs(arr[i] - arr[i-1]) <= 1){
//                dp[i] = dp[i-1] + 1;
//            }
//            res = Math.max(res, dp[i]);
//        }
//
//        System.out.println(res);
//    }
//
//}

