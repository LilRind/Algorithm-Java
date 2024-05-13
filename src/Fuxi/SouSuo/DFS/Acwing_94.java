package Fuxi.SouSuo.DFS;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();  // 读取输入的排列长度
        dfs(1);  // 从第一个位置开始深度优先搜索
    }

    static void dfs(int u) {

    }
}
