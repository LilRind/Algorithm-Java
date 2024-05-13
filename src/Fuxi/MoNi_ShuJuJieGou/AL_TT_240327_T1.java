package Fuxi.MoNi_ShuJuJieGou;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
5 4
1145 1200 1300 1500 1600
10 270 450 500
*/
// 24_04_22 10:48 - 10:59 - 11:02
// 算法考点：哈希表+贡献法计数+快速幂
public class AL_TT_240327_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long max = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++){
            a[i] = sc.nextLong();
            pq.add(a[i]);
            max = Math.max(max, a[i]);
        }
        for (int i = 0; i<m; i++){
            b[i] = sc.nextLong();
            long tem = pq.poll();
            max = Math.max(max, tem+b[i]);
            pq.add(tem+b[i]);
            System.out.println(max);
        }
    }
}
