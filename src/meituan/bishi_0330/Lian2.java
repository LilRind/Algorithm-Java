package meituan.bishi_0330;

import java.util.Scanner;

public class Lian2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            max = a[i] > max ? a[i] : max;
        }
        for(int i = 0; i < n; i++){
            a[i] = 2 * a[i] > max ? 2 * a[i] : max;
            System.out.print(a[i] + " ");
        }

    }
}
