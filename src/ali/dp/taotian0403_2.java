package ali.dp;

import java.util.*;

// dp
public class taotian0403_2 {
    static int N = (int)2e5+10; // 数组长度[1, 2e5]
    static int[] a = new int[N], f = new int[N]; // 定义f[i]表示处理前i个数字的最小操作次数
    static int t, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            for (int i = 1; i <= n; i++) a[i] = scanner.nextInt();
            f[0] = 0; // 第一个元素为了下标不越界
            for (int i = 1; i <= n; i++) { // 从 i = 1 开始遍历
                f[i] = f[i - 1] + 1; // 第一种方法，将第i个元素染红
                for (int j = i - 1; j > 0; j--) { // 像i的左边遍历
                    if (a[i] != a[j]) { // 当第i个元素和第j个元素值不同，比较第一种和第二种的大小
                        // f[j - 1] + 1(这是第二种方法，区间染红)，f[i](第一种方法，将第i个元素染红)
                        f[i] = Math.min(f[j - 1] + 1, f[i]);
                    }
                }
            }
            System.out.println(f[n]);
        }
    }
}