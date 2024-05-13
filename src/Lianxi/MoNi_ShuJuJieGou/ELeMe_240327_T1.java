package Lianxi.MoNi_ShuJuJieGou;

import java.util.*;

// 24_04_21 21:45 - 22:17 想复杂了
// 算法考点：模拟 分类讨论
public class ELeMe_240327_T1 {
    // 定义 solve 方法用于解决单个测试用例
    static void solve() {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong(); // 读取输入的长整型数 a，表示火元素个数
        long b = scanner.nextLong(); // 读取输入的长整型数 b，表示水元素个数
        long c = scanner.nextLong(); // 读取输入的长整型数 c，表示风元素个数

        // 如果水元素个数加风元素个数小于 3，无法构成满足条件的盒子，输出 -1 并结束方法
        if (b + c < 3) {
            System.out.println(-1);
            return;
        }

        // 计算最小满足条件的盒子数 minv
        // 最小满足条件的盒子数应该是火元素个数的一半再加 1
        int minv = 1 + (int)((a + 1) >> 1); // 使用位运算右移一位并加 1，以取得最小值
        // (int)((a + 1) >> 1) 无视a的奇偶属性，位运算右移一位的方式来实现，相当于除以 2。
        // 这样做的好处是可以将奇数向上取整，而不影响偶数。因为在计算时先将 a 加 1，这样无论 a 是奇数还是偶数，结果都会向上取整到下一个整数。

        // 将水元素个数调整为至少为 3，以满足题目条件
        while (b < 3 && c > 0) {
            b++; // 增加水元素个数
            c--; // 减少风元素个数
        }

        // 计算最大满足条件的盒子数 maxv
        // 最大满足条件的盒子数应该是水元素和风元素总数的整除值再加上火元素个数
        // b>3但是b%3 != 0，那么，最大数量必然是水元素全部在(b/3)个盒子里（风元素单独在另外的盒子里），火，水各占a、c个格子
        long maxv = b / 3 + c + a; // 最大值由 b/3，c 和 a 的和组成

        // 输出最小满足条件的盒子数和最大满足条件的盒子数
        System.out.println(minv + " " + maxv);
    }

    // 主方法用于循环处理多个测试用例
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // 读取测试用例数量
        while (q-- > 0) // 循环处理每个测试用例
            solve(); // 调用 solve 方法解决当前测试用例
    }
}




//public class ELeMe_240327_T1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int g = sc.nextInt();
//        while (g-- > 0){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            int c = sc.nextInt();
//
//            int byu = b%3; // b/3的余数
//
//            int a2;
//            if(a%2 == 0){
//                a2 = a/2;
//            }else {
//                a2 = a/2 + 1;
//            }
//            int b3;
//            int bcMax;
//            if(b%3 == 0){
//                b3 = b/3;
//                bcMax = b3+c;
//            }else {
//                b3 = b/3 + 1;
//                bcMax = b3 + c-(3-byu);
//            }
//
//            if(c < 3-byu){
//                System.out.println(-1);
//                continue;
//            }else {
//                System.out.print(a2+b3 + " " + (a+bcMax));
//            }
//
//        }
//
//    }
//}
