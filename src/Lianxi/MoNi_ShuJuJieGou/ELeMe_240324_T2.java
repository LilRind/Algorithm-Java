package Lianxi.MoNi_ShuJuJieGou;

import java.util.*;

// 算法考点：哈希表+贡献法计数+快速幂
public class ELeMe_240324_T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> cnts = new HashMap<>();
        for(int i = 0; i < n; i++) {
            cnts.put(a[i] + b[i], cnts.getOrDefault(a[i] + b[i], 0) + 1);
        }
        int[] twos = new int[n + 1]; // 构造2的n次方
        twos[0] = 1;
        int mod = (int)1e9 + 7;
        for(int i = 1; i <= n; i++) {
            twos[i] = (int)(((long)twos[i - 1] * 2) % mod);
        }
        int res = 0;
        for(int v : cnts.values()) { // 遍历每个值
            res = (res + ((twos[v] - 1 + mod) % mod)) % mod; // 2的v-1累加
        }
        System.out.println(res);
    }
}
