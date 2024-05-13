package Lianxi.DP;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

// 2023.08.11-KS-第一题-塔子哥选数
// https://codefun2000.com/p/P1439
// 这道题有点困难，可以之后再看
// 全排列 + 路径
public class KuaiShou_23_01 {

    public static void main(String[] args) throws IOException {
        // 读取输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] every = br.readLine().split(" ");
        int n = every.length;

        long[] a = new long[n + 1];  // 存储输入数组
        long[] f = new long[n + 1];  // 存储状态转移值
        int[] ok = new int[n + 1];   // 记录状态转移路径
        for (int i = 1; i <= n; ++i) {
            a[i] = Integer.parseInt(every[i - 1]);  // 初始化输入数组
        }

        // 初始化状态转移数组和路径记录数组
        for (int i = 0; i <= n; ++i) {
            f[i] = 0;
            ok[i] = 0;
        }

        f[0] = 0;  // 初始状态，表示没有任何元素时的值为0
        f[1] = a[1];  // 只有一个元素时，最大值为这个元素的值
        ok[1] = 1;  // 记录第一个元素的状态

        // 计算状态转移值和路径记录
        for (int i = 2; i <= n; ++i) {
            // 计算当前位置的状态转移值
            f[i] = f[i - 1];  // 默认情况下，当前状态的值等于前一个状态的值
            long val = f[i - 2] + a[i];  // 尝试加上当前元素后的值
            if (val >= f[i - 1]) {  // 如果加上当前元素后的值大于等于前一个状态的值
                f[i] = val;  // 更新当前状态的值为加上当前元素后的值
                ok[i] = 1;  // 记录当前状态需要加上当前元素
            }
        }

        List<Integer> ans = new ArrayList<>();  // 存储结果的路径
        int cur = n;
        while (cur > 0) {
            // 根据状态转移路径记录构造结果路径
            if (ok[cur] == 1) {  // 如果当前状态需要加上当前元素
                ans.add(cur - 1);  // 将当前元素的索引添加到结果路径中
                cur -= 2;  // 跳过当前元素和它前面的元素，因为已经加入结果路径
            } else {
                cur -= 1;  // 否则，只跳过当前元素
            }
        }

        // 输出结果路径和最终结果
        for (int i = ans.size() - 1; i >= 0; --i) {
            System.out.print(ans.get(i) + " ");  // 输出结果路径
        }
        System.out.println();  // 换行
        System.out.println(f[n]);  // 输出最终结果
    }
}
