package ali.tanxin.lianxi;

import java.util.Arrays;
import java.util.Scanner;

// 算法考点：贪心 枚举
public class elema0324_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);

        int res = 2*n+1;
        for (int i = 0; i < n; i++){
            res = Math.min(res, a[i]+2*(n-i-1));
        }
        System.out.println(res);
        scanner.close();
    }
}