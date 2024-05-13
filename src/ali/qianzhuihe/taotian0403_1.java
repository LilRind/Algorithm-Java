package ali.qianzhuihe;

import java.util.*;

public class taotian0403_1 {
    static int N = (int)1e5 + 10; // 1<= n, q <= 1e5
    static int[] s = new int[N];

    static int f(int x) { // 求取数位之和
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 元素个数
        int q = scanner.nextInt(); // 询问次数
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            s[i] = s[i - 1] + f(x); // 求取前缀和，s[0]默认初始化为0
        }
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int sum = s[r] - s[l - 1]; // l到r的前缀和
            if (sum % 3 == 0) { // 是否被3整除
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}