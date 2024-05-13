package Fuxi.DP;

import java.util.Scanner;


public class XieCheng_240328_03 {

    public static void main(String[] args) {

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
