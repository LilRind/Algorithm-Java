package Fuxi.SouSuo.DFS;

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

    }

}
