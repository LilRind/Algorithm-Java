package meituan.bishi_0316;

import java.util.Scanner;

// 通过测例
public class Lian2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] l = new int[q];
        int[] r = new int[q];
        int sum = 0;
        int zero = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(a != 0) {
                sum += a;
            }else {
                zero++;
            }
        }

        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt();
            r[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int min = sum+zero*l[i];
            int max = sum+zero*r[i];
            System.out.println(min + " " + max);
        }

    }
}
