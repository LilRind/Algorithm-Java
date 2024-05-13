package xiaohongshu.bishi_0324;

import java.util.*;

public class T3 {
    static int n; // 题解数量
    static int[] a; // 每个笔记的点赞数
    static long sum = 0; // 总点赞数

    // 检查当前点赞数是否符合条件
    static boolean check(long a_i, long x) {
        // 如果当前点赞数 x 减去当前笔记的点赞数 a_i 小于等于剩余笔记的总点赞数加上 1，那么就认为当前点赞数 x 可以满足条件，即当前笔记所需的额外点赞数小于等于剩余笔记的总点赞数加上 1。
        return x - a_i <= x * (n - 1) - (sum - a_i) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取题解数量n
        a = new int[n]; // 初始化数组用于存储每个笔记的点赞数
        int maxv = 0; // 初始化最大点赞数
        // 读取每个笔记的点赞数，并计算总点赞数和最大点赞数
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
            maxv = Math.max(maxv, a[i]); // 更新最大点赞数
        }
        // 处理特殊情况：如果题解数量为2
        if (n == 2) {
            for (int i = 0; i < n; i++) {
                if (a[i] == maxv) System.out.println(a[i]); // 如果当前笔记的点赞数是最大点赞数，输出该点赞数
                else System.out.println("-1"); // 否则输出-1
            }
        }
        // 对于每个笔记，计算满足条件的最小点赞数，并输出结果
        for (int i = 0; i < n; i++) {
            long l = maxv, r = (long)1e12; // 设置二分搜索的左右边界
            while (l < r) {
                long mid = l + (r - l) / 2; // 计算中间点
                if (check(a[i], mid)) r = mid; // 如果当前点赞数符合条件，将右边界缩小到mid
                else l = mid + 1; // 否则将左边界扩大到mid+1
            }
            // 计算并输出最小点赞数，总点赞数加上其他笔记的最大点赞数减去当前笔记的点赞数（除当前笔记外其他笔记的总点赞数），并加上0或当前笔记的最大点赞数减去当前笔记的点赞数再减去1中的最大值（除当前笔记外其他笔记的最大点赞数。）。
            long res = sum + l - a[i] + Math.max(0, l - a[i] - 1);
            System.out.println(res);
        }
    }
}
