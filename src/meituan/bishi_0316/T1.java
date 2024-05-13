package meituan.bishi_0316;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for(int i = 0 ; i < n; i++){
            a[i] = in.nextInt();
            sum += a[i];
        }
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(sum - x- y);

    }
}