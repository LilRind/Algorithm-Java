package Lianxi.DP;

import java.util.Scanner;


public class XieCheng_240328_03 {
    static final int N = (int)1E5+10;
    static int n;
    static int[] a = new int[N];
    static long res = 0, sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        res = sum;  // 答案初始化
        for(int i = 0; i < n; i++){
            if(a[i] % 2 != 0) continue;  // 跳过奇数
            int j = i;  // 找到一段连续的偶数区间
            while(j < n && a[j] % 2 == 0) j++;  // 定位区间[i,j-1]
            long cur = 0, minv = Long.MAX_VALUE;  // 求区间最小值
            for(int k = i; k < j; k++){
                cur = Math.min(cur, 0) + a[k]; // 状态方程
                minv = Math.min(minv, cur); // 更新区间最小值
            }
            res = Math.max(res, sum - minv / 2); // 更新最终所有元素之和的最大值
            i = j - 1;  // 双指针移动到j-1处，再j-1向n遍历
        }
        System.out.println(res);
    }
}

// 12:35 - 13.03
//public class XieCheng_240328_03 {
//    static int N = 100010;
//    static int[] dp = new int[N];
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        int start, end; // 记录最小区间和的指针
//        for (int i = 0; i<n; i++){
//            arr[i] = scanner.nextInt();
//        }
//        int sum = 0;
//        for (int i = 1; i < n; i++){
//            for(int j = i-1; j>=0; j--){
//                if(arr[j] <= 0){
//                    sum += arr[j];
//                }else(arr[j])
//            }
//        }
//        for (int i = 1; i < n; i++){
//            if(arr[i-1] <= 0){
//                end = i-1;
//                dp[i] = dp[i-1] + arr[i-1];
//            }else if(arr[i-1] <= dp[i-1]){
//                start = i-1;
//                dp[i] = arr[i-1];
//            }else{
//                dp[i] = dp[i-1];
//            }
//        }
//
//    }
//}
