package Lianxi.SouSuo.DFS;

import java.util.Scanner;

// https://www.acwing.com/problem/content/description/96/
// 94. 递归实现排列型枚举
// 23:08 - 23:12 - 23:23
// 对于回溯过程不理解的同学，可以参考这个题解，个人觉得讲解的非常清楚：https://www.acwing.com/solution/content/44647/
/*
用 path 数组保存排列，当排列的长度为 n 时，是一种方案，输出。
用 state 数组表示数字是否用过。当 state[i] 为 1 时：i 已经被用过，state[i] 为 0 时，i 没有被用过。
dfs(i) 表示的含义是：在 path[i] 处填写数字，然后递归的在下一个位置填写数字。
回溯：第 i 个位置填写某个数字的所有情况都遍历后， 第 i 个位置填写下一个数字。
 */

public class Acwing_94 {
    static final int N = 10;  // 常量 N 表示最大长度
    static int[] nums = new int[N];  // 存储排列的数组，长度为 N
    static boolean[] st = new boolean[N];  // 标记数组，表示每个数字是否已经被使用过
    static int n;  // 排列的长度

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();  // 读取输入的排列长度
        dfs(1);  // 从第一个位置开始深度优先搜索
    }

    static void dfs(int u) {
        // 如果已经排列完所有的数字（即1次全排列完成），输出结果并返回
        if (u > n) {
            for (int i = 1; i <= n; i++)
                System.out.print(nums[i] + " ");  // 输出当前排列
            System.out.println();  // 换行
            return;  // 返回上一层递归
        }
        // 枚举可选的数字
        for (int i = 1; i <= n; i++) {
            // 如果数字未被使用过，选择它并继续搜索
            if (!st[i]) {
                nums[u] = i;  // 将数字 i 放入当前位置u
                st[i] = true;  // 标记数字 i 已被使用
                dfs(u + 1);  // 继续搜索下一个位置
                st[i] = false;  // 恢复状态，回溯
            }
        }
    }
}


//public class Acwing_94 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] vis = new int[n+1];
//        int[] a = new int[n+1];
//        for (int i = 1; i<=n; i++){
//            a[i] = i;
//        }
//        huisu(a);
//    }
//    public static void huisu(int[] a){
//        if()
//
//    }
//}
