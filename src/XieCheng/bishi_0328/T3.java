package XieCheng.bishi_0328;

import java.util.Scanner;

// 24_0506 18:18 -

/*
5
8 -4 2 -6 -5
输出：
-1

6
1 -2 -4 3 -6 -2
输出：
-6

 */

public class T3 {
    static final int N = (int) 1E5 + 10;
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
                cur = Math.min(cur, 0) + a[k]; // 尽可能保留负数
                minv = Math.min(minv, cur); // 判断
            }
            res = Math.max(res, sum - minv / 2);
            i = j - 1;  // 双指针
        }
        System.out.println(res);
    }
}
