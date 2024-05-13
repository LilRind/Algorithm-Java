package Fuxi.SouSuo.DFS;

// https://codefun2000.com/p/P1163
// dfs + 自定义排序
// 22:53 - 23:05
// 有点难，耗脑壳，后面有官方答案
import java.util.Scanner;


public class HuaWei_220923_T1 {
    public static void main(String[] args) {

    }
}

/* 官方
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int[] w, f, d, p;
    static List<Integer>[] g;

    public static int dfs(int u) {
        f[u] = 1;
        for (int x : g[u]) {
            f[u] += dfs(x);
        }
        return f[u];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = new int[n];
        f = new int[n];
        d = new int[n];
        p = new int[n];
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            p[i] = i;
            if (w[i] != -1) {
                d[i]++;
                g[w[i]].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                dfs(i);
            }
        }

        Integer[] pWrapper = IntStream.of(p).boxed().toArray(Integer[]::new);

        Arrays.sort(pWrapper, (a, b) -> {
            if (f[a] != f[b]) return f[a] > f[b] ? -1 : 1;
            return a - b;
        });

        for (int i = 0; i < n; i++) {
            System.out.print(pWrapper[i] + " ");
        }
    }
}
 */