package Lianxi.MoNi_ShuJuJieGou;

import java.util.Scanner;

// 签到题/秒杀题,注意坑 m <= 1L * n * (n - 1) / 2
// 算法考点：模拟 简单图论
// 24_04_22 14:49 - 14:57
public class AL_MY_240330_T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if(m >= n - 1 && m <= 1L * n * (n - 1) / 2){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
