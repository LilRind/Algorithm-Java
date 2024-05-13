package Lianxi.SouSuo.DFS;

import java.util.Scanner;

// 2023柠檬微趣-排队
// https://codefun2000.com/p/P1280
// 24_04_23 9:38 - 10:10 - 10:14
// 和官方答案不一样，因为是按照Acwing_94的模板写的
// https://xuq7bkgch1.feishu.cn/docx/CAbedNJ5KobvinxdyKgcKsrlnrd#OgRodVATHoCfoZxC4aKckfPwnsg
public class ningmengweiqu_230506_T4 {
    static int M = 10; // 学生人数最大值
    static int m; // 学生人数 [1, 10]
    static int N; // 第N个方案 [1, 1e9]
    static int[] nums = new int[M]; // 存储全排列的一种方案
    static boolean[] vis = new boolean[M]; // 记录访问状态
    static int cnts = 0; // 方案的计数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        N = sc.nextInt();
        if(jiecheng(m) < N){
            System.out.println(-1);
        }
        dfs(1);
    }

    // 全排列nums的第u位的值为多少
    public static void dfs(int u){
        // 计数条件（达到全排列就cnts + 1）
        if(u > m){ // 输出条件，但本题中我们需要满足cnts == N才输出
            cnts++; // 方案的计数+1
            if (cnts == N){ // 满足cnts == N， 输出
                for (int i = 1; i <= m; i++){
                    System.out.print(nums[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= m; i++){
            if(!vis[i]){ // 未被访问，可以访问
                nums[u] = i;
                vis[i] = true;
                dfs(u+1);
                vis[i] = false; // 当前全排列的一种方案结束，重置访问值
            }
        }

    }

    // 求取x的阶乘数
    public static int jiecheng(int x){
        if(x <= 1){
            return 1;
        }
        return x * jiecheng(x-1);
    }
}
