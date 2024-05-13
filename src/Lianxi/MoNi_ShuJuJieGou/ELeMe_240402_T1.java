package Lianxi.MoNi_ShuJuJieGou;

import java.util.HashMap;
import java.util.Scanner;

// 签到题/秒杀题
// 算法考点：模拟
// 15:58 - 16:05 - 16:05
public class ELeMe_240402_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        //long[] a = new long[n];
        //long[] b = new long[n];
        long sumA = 0;
        long sumB = 0;

        for (int i=0; i<n; i++){
            a[i] = sc.nextInt(); // a[i] = sc.nextLong();
            sumA += a[i];
        }
        for (int i=0; i<n; i++){
            b[i] = sc.nextInt(); // b[i] = sc.nextLong();
            sumB += b[i];
        }

        int res = 0;
        for (int i=0; i<n; i++){
            if(sumA + a[i] == sumB){
                res++;
            }
        }
        System.out.println(res);

    }
}
