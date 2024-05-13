package Lianxi.ErFen;

import java.util.*;

// 二分答案 O（1）
// https://codefun2000.com/p/221
public class meituan_23_0415_fentangguo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 输入测试用例数
        //            int r = (a + b) / n; // 初始化最大糖果数为(a+b)/n，即每个人平均分得的糖果数
        while (T-- > 0) {
            int n = scanner.nextInt(); // 人数
            int a = scanner.nextInt(); // a糖果数
            int b = scanner.nextInt(); // b糖果数
            int l = 1; // 初始化最小糖果数为1
            int r = Math.min(a,b);
            while (l < r) { // 左必右开写法[l,r)
                int mid = (l + r + 1) / 2; // 取中间值，向上取整
                if (check(a, b, n, mid)) { // 每个人分得的糖果数大于等于mid
                    l = mid; // 如果满足条件，则最小糖果数更新为中间值
                } else {
                    r = mid - 1; // 如果不满足条件，则最大糖果数更.新为中间值减一
                }
            }
            System.out.println(l); // 输出最少糖果的小朋友最多能获得多少糖果
        }
    }

    private static boolean check(int a, int b, int n, int x) {
        return (a / x + b / x) >= n; // 检查是否满足条件：每个人分得的糖果数大于等于x
    }
}





//public class meituan_23_0415_fentangguo {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // n组人数、a糖果、b糖果
//        int[] p = new int[n]; // 人数
//        int[] a = new int[n]; // a糖果
//        int[] b = new int[n]; // b糖果
//
//        for(int i = 0; i<n; i++){
//            p[i] = sc.nextInt();
//            a[i] = sc.nextInt();
//            b[i] = sc.nextInt();
//            check(p[i], a[i], b[i]);
//        }
//    }
//    public static void check(int p, int a, int b){
//        if(a+b <= p){
//            System.out.println(1);
//        }else{
//            System.out.println(a/p + b/p);
//        }
//    }
//}
