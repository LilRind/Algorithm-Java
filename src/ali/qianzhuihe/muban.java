package ali.qianzhuihe;

import java.util.Scanner;

public class muban {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000005;
        int[] a = new int[N];
        int[] S = new int[N];

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] q = new int[m]; // 存储询问区间的和

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            S[i] = S[i - 1] + a[i];
        }

        for (int j = 0; j < m; j++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            q[j] = S[r] - S[l - 1]; // 计算每次区间和并存储
        }

        System.out.println();

        for (int e: q){ // 输出区间和
            System.out.println(e);
        }

        sc.close();
    }
}