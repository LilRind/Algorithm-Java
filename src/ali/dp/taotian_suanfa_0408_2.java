package ali.dp;

import java.util.*;

public class taotian_suanfa_0408_2 {
    static final int N = (int)2E5 + 10; // 数组的最大长度
    static int n; // 格子的数量
    static int[] a = new int[N]; // 存储每个格子的分数，分数[-10^9, 10^9]
    static long[] f = new long[N]; // 存储中间结果的数组

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取格子的数量
        for (int i = 1; i <= n; i++) a[i] = scanner.nextInt(); // 读取每个格子的分数
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 1));   // 斐波那契数列初始化
        for (int i = 2; b.get(b.size() - 1) <= n; i++) { // 生成不大于 'n' 的斐波那契数列
            b.add(b.get(i - 1) + b.get(i - 2));
        }
        int m = b.size(); // 斐波那契数列的长度
        Arrays.fill(f, Long.MIN_VALUE); // 将 'f' 数组初始化为最小值
        f[1] = a[1]; // 第一个格子的分数即为初始值
        for (int i = 2; i <= n; i++) { // 动态规划循环
            for (int j = 1; j < m; j++) { // 遍历斐波那契数列
                int k = i - b.get(j); // 计算索引 'k'，跳跃的长度为斐波那契数列的某一项
                if (k < 0) break; // 如果 'k' 为负数，则跳出循环
                f[i] = Math.max(f[i], f[k] + a[i]); // 更新跳到第 'i' 个格子的最大得分
            }
        }
        System.out.println(f[n]); // 打印最终结果，即跳到最后一个格子的最大得分
    }
}
