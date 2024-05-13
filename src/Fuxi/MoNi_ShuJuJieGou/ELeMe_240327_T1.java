package Fuxi.MoNi_ShuJuJieGou;

import java.util.Scanner;

// 注意 b < 3 && c > 0的情况
// 24_04_22 10:33 - 10:40 - 10:47 (开始做题 - 结束做题 - 评估答案)
// 算法考点：模拟 分类讨论
public class ELeMe_240327_T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        while (g-- > 0){
            // a, b, c [1, 1e9]
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(b+c < 3){
                System.out.println(-1);
                continue;
            }
            int min = 1 + (int)((a + 1) >> 1);
            while (b < 3 && c > 0) {
                b++;
                c--;
            }
            int max = a + b/3 + c;
            System.out.println(min + " " + max);
        }
        sc.close();
    }
}
