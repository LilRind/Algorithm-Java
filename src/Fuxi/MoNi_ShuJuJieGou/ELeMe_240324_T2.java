package Fuxi.MoNi_ShuJuJieGou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

// 不熟练，多练练
// 24_04_22 10:10 - 10:29
// 算法考点：哈希表+贡献法计数+快速幂
public class ELeMe_240324_T2 {
    static int mod = (int)1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i<n; i++){
            b[i] = sc.nextInt();
        }
        for (int i = 0; i<n; i++){
            map.put(a[i] + b[i], map.getOrDefault(a[i]+b[i], 0) + 1);
        }
        int[] two = new int[n+1];
        two[0] = 1;
        for (int i = 1; i<=n; i++){
            two[i] = (int)(((long)two[i - 1] * 2) % mod);
        }
        int res = 0;
        for (int v: map.values()){
            res = (res + ((two[v] - 1 + mod) % mod)) % mod;
        }
        System.out.println(res);
    }
}
